public class Node {

    private Node[] nodes;
    private String leafData;

    public Node() {
    }

    public Node(Node[] nodeObj, String leafData) {
        this.nodes = nodeObj;
        this.leafData = leafData;
    }

    public Node[] getNodes() {
        return nodes;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }

    public String getLeaf() {
        return leafData;
    }

    public void setLeaf(String leafData) {
        this.leafData = leafData;
    }
}
