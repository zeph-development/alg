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

        Node rootSameTree1 = TreeUtils.buildRandomLeafDataTree();
//        Node rootSameTree2 = rootSameTree1;
        Node rootSameTree2 = TreeUtils.buildRandomLeafDataTree();

        boolean isEqual = TreeUtils.compareTrees(rootSameTree1, rootSameTree2);
        System.out.println(isEqual);
    }


}
