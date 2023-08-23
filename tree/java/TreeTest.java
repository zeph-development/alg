public class TreeTest {

    public static void main(String[] args) {
//        Node root = TreeUtils.buildTestTree();
//        int maxDepth = TreeUtils.maxDepth(root);
//        System.out.println(maxDepth);
//
//        root = new Node();
//        TreeUtils.generateRandomBinaryTree(root);
//        System.out.println(root);
//
//        root = new Node();
//        TreeUtils.generateRandomTree(root);
//        System.out.println(root);

//        Node rootSameTree1 = TreeUtils.buildRandomLeafDataTree();
//        Node rootSameTree2 = rootSameTree1;
//        Node rootSameTree2 = TreeUtils.buildRandomLeafDataTree();

//        boolean isEqual = TreeUtils.compareTrees(rootSameTree1, rootSameTree2);
//        System.out.println(isEqual);

        int depth = 4;       // Change the depth of the tree as desired
        int maxValue = 100;  // Change the maximum value for node data as desired

        BinaryNode randomTree = TreeUtils.generateRandomBinaryTree(depth, maxValue);
        TreeUtils.printBinaryTree(randomTree, "", true);
        TreeUtils.depthFirstTraversal(randomTree);
    }
}
