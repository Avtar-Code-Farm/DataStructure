package FacebookProblems.Medium;

import Patterns.Tree.TreeNode;

public class RangeSumofBST {
    static int sum = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.right = new TreeNode(18);
        do_dfs(root, 7, 15);
    }

    public static void do_dfs(TreeNode root, int low, int high){
        if(root == null) return;
        if(root.data <= high && root.data >= low)
            sum += root.data;
        if(high > root.data )
            do_dfs(root.right, low, high);
        if(low < root.data)
            do_dfs(root.left, low, high);
    }
}

