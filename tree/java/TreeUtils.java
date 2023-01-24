import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Math.random;

public class TreeUtils {

    private static final ExecutorService executor = Executors.newFixedThreadPool(10);
    private static final AtomicInteger atomicHeight = new AtomicInteger(0);

    public static Node buildTestTree() {
        Node root = new Node();
        root.setNodes(new Node[]{new Node(), new Node(), new Node()});

        root.getNodes()[0].setNodes(new Node[]{new Node()});
        root.getNodes()[0].getNodes()[0].setNodes(new Node[]{new Node()});
        root.getNodes()[0].getNodes()[0].getNodes()[0].setLeafData("randomData(%f)".formatted(Math.random() * 100));

        root.getNodes()[1].setLeafData("randomData(%f)".formatted(Math.random() * 100));
        root.getNodes()[2].setLeafData("randomData(%f)".formatted(Math.random() * 100));
        return root;
    }

    public static int maxDepth(Node node) {
        int levelMaxDepth = 0;
        if (node.getNodes() != null && node.getNodes().length != 0) {
            for (Node childNode : node.getNodes()) {
                int maxDepth = maxDepth(childNode) + 1;

                if (levelMaxDepth < maxDepth) {
                    levelMaxDepth = maxDepth;
                }
            }
        }

        return levelMaxDepth;
    }

    public static void generateRandomTree(Node root) {
        generateRandomBasicTree(root, 2, 3, atomicHeight.get());
        waitForExecutorToFinish(5);
    }

    public static void generateRandomBinaryTree(Node root) {
        generateRandomBasicTree(root, 2, 10, atomicHeight.get());
        waitForExecutorToFinish(5);
    }

    private static void generateRandomBasicTree(Node parentNode, int levelNodeLimit, int maxHeight, int currentHeight) {
        int randomNodesSizePerLevel = 1 + (int) (random() * levelNodeLimit);

        if (currentHeight >= maxHeight) {
            parentNode.setLeafData("randomData(%f)".formatted(random()));
        } else {
            Node[] childNodes = new Node[randomNodesSizePerLevel];
            for (int i = 0; i < randomNodesSizePerLevel; i++) {
                childNodes[i] = new Node();
            }
            parentNode.setNodes(childNodes);

            final int nextHeight = atomicHeight.addAndGet(1);
            for (Node child : childNodes) {
                executor.execute(
                        () -> {
                            if (child != null) {
                                generateRandomBasicTree(child, levelNodeLimit, maxHeight, nextHeight);
                            }
                        }
                );
            }
        }
    }

    private static void waitForExecutorToFinish(int seconds) {
        try {
            executor.awaitTermination(seconds, TimeUnit.SECONDS);
            System.out.println("Finish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
