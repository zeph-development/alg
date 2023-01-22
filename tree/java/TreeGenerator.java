import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Math.random;

public class TreeGenerator {

    private static final ExecutorService executor = Executors.newFixedThreadPool(10);
    private static final AtomicInteger atomicHeight = new AtomicInteger(0);

    public static void main(String[] args) {
        Node randomTreeRoot = new Node();
        generateRandomTree(randomTreeRoot);

        Node binaryTreeRoot = new Node();
        generateRandomBinaryTree(binaryTreeRoot);

        waitForExecutorToFinish(5);
    }

    public static void generateRandomTree(Node root) {
        generateRandomBasicTree(root, 2, 3, atomicHeight.get());
    }

    public static void generateRandomBinaryTree(Node root) {
        generateRandomBasicTree(root, 2, 10, atomicHeight.get());
    }

    private static void generateRandomBasicTree(Node parentNode, int levelNodeLimit, int maxHeight, int currentHeight) {
        int randomNodesSizePerLevel = 1 + (int) (random() * levelNodeLimit);

        if (currentHeight == maxHeight) {
            parentNode.setLeafData("randomData(%f)".formatted(random()));
        } else {
            Node[] childNodes = new Node[randomNodesSizePerLevel];
            for (int i = 0; i < randomNodesSizePerLevel; i++) {
                childNodes[i] = new Node();
            }
            parentNode.setNodes(childNodes);

            if (currentHeight < maxHeight) {
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
