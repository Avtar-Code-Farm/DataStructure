package Patterns.Tree.BFS;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    // some question required next pointer as well i.e connect level order nodes
    public TreeNode next = null;

    TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

}
