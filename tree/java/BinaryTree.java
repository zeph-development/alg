import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTree {

    private static final ExecutorService executor = Executors.newFixedThreadPool(10);
    private static final AtomicInteger atomicHeight = new AtomicInteger(0);
    private static final Random random = new Random();

    public static BinaryNode generateRandomBinaryTree(int depth, int maxValue) {
        if (depth <= 0) {
            return null;
        }

        int data = random.nextInt(maxValue + 1);
        BinaryNode root = new BinaryNode(data);

        root.left = generateRandomBinaryTree(depth - 1, maxValue);
        root.right = generateRandomBinaryTree(depth - 1, maxValue);

        return root;
    }

    public static void printBinaryTree(BinaryNode root, String prefix, boolean isLeft) {
        if (root != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.data);
            printBinaryTree(root.left, prefix + (isLeft ? "│   " : "    "), true);
            printBinaryTree(root.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    public static void depthFirstTraversal(BinaryNode root) {
        if (root == null) {
            return;
        }

        Stack<BinaryNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            BinaryNode currentNode = stack.pop();
            System.out.print(currentNode.data + " ");

            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
    }

    public static void main(String[] args) {
        int depth = 4;       // Change the depth of the tree as desired
        int maxValue = 100;  // Change the maximum value for node data as desired

        BinaryNode randomTree = generateRandomBinaryTree(depth, maxValue);
        printBinaryTree(randomTree, "", true);
        depthFirstTraversal(randomTree);
    }
}
