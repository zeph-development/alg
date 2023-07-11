import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.w3c.dom.Node;

import static java.lang.Math.random;

public class TreeUtils {

    private static final ExecutorService executor = Executors.newFixedThreadPool(10);
    private static final AtomicInteger atomicHeight = new AtomicInteger(0);

    public static Node buildRandomLeafDataTree() {
        Node root = new Node();
        root.setNodes(new Node[]{new Node(), new Node(), new Node()});

        root.getNodes()[0].setNodes(new Node[]{new Node()});
        root.getNodes()[0].getNodes()[0].setLeaf("randomData(%f)".formatted(Math.random() * 100));

        root.getNodes()[1].setLeaf("randomData(%f)".formatted(Math.random() * 100));
        root.getNodes()[2].setLeaf("randomData(%f)".formatted(Math.random() * 100));
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
            parentNode.setLeaf("randomData(%f)".formatted(random()));
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

    public static boolean compareTrees(Node node1, Node node2) {
        if (node1 != null && node2 != null
            && (Objects.equals(node1.getNodes(), node2.getNodes())
                || (node1.getNodes() != null && node2.getNodes() != null
                    && node1.getNodes().length == node2.getNodes().length))) {

            if (node1.getNodes() == null && node2.getNodes() == null) {
                return Objects.equals(node1.getLeaf(), node2.getLeaf());
            }

            boolean isEqual = true;
            for (int i = 0; i < node1.getNodes().length; i++) {
                isEqual &= compareTrees(node1.getNodes()[i], node2.getNodes()[i]);
            }
            return isEqual;
        }
        return false;
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
