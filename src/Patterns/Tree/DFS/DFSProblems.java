package Patterns.Tree.DFS;

import Patterns.Tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class DFSProblems {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(7);
        boolean res = isSumExistsRecursive(root, 11);
        List<List<Integer>> allPath = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        getPathToSum(root, 11, currentPath, allPath);

        List<Integer> given_path = new ArrayList<>();
        given_path.add(1);
        given_path.add(3);
        given_path.add(7);
        currentPath = new ArrayList<>();
        res = givenSequenceExistsInATree(root, currentPath, given_path);
        res = isGivenPathExistSimplified(root, 0, given_path);


        // Count total sum path;
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(7);
        root1.right = new TreeNode(9);

        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(5);

        root1.right.left = new TreeNode(2);
        root1.right.right = new TreeNode(3);

        int sum_count = CountPathsForSum(root1, 12);

        // -------- Get diameter of the tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        root2.right.left = new TreeNode(5);
        root2.right.right = new TreeNode(6);

        root2.right.left.left = new TreeNode(7);
        root2.right.left.right = new TreeNode(8);

        root2.right.left.right.right = new TreeNode(10);

        root2.right.right.right = new TreeNode(9);
        root2.right.right.right.right = new TreeNode(11);


        AtomicInteger treeDiameter = new AtomicInteger(0);
        int diameter = getDiameterOfTheTree(root2, treeDiameter);

        AtomicInteger maxSumPathFromTheRoot = new AtomicInteger(0);
        getpathMaxSumFromTheRoot(root2,maxSumPathFromTheRoot);

        AtomicInteger maxSumPathFromAnyNodeToAnyNode = new AtomicInteger(0);
        getpathMaxSumFromAnyNodeToAnyNode(root2,maxSumPathFromAnyNodeToAnyNode);



    }

    private static int getpathMaxSumFromAnyNodeToAnyNode(TreeNode node, AtomicInteger maxSumPathFromAnyNodeToAnyNode) {
        if(node == null) return 0;

        int left = getpathMaxSumFromAnyNodeToAnyNode(node.left, maxSumPathFromAnyNodeToAnyNode);
        int right = getpathMaxSumFromAnyNodeToAnyNode(node.right, maxSumPathFromAnyNodeToAnyNode);

        int currMaxSumIncludingCurrentNode = left + right + node.data;

        maxSumPathFromAnyNodeToAnyNode.set(Math.max(maxSumPathFromAnyNodeToAnyNode.get(), currMaxSumIncludingCurrentNode));

        return Math.max(left,right) + node.data;

    }

    public static boolean isSumExistsRecursive(TreeNode root, int sum) {
        if(root == null) return  false;
        if(root.data == sum && root.left == null && root.right == null ) return true;
        if(sum == 0) return true;

        boolean left = isSumExistsRecursive(root.left, sum - root.data);
        return  left == true ? left : isSumExistsRecursive(root.right, sum - root.data);
    }

    public static void getPathToSum(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> allPath) {
        if(root == null) return;

        currentPath.add(root.data);

        if(root.data == sum && root.left == null && root.right == null) // it means we are at the last node
        {
            allPath.add(new ArrayList<>(currentPath));
            return;
        }

        // check left side
        getPathToSum(root.left, sum - root.data, currentPath, allPath);
        getPathToSum(root.right, sum - root.data, currentPath, allPath);

        // since we have processed the current node and all its children we have to remove it from the currentPath
        currentPath.remove(currentPath.size()-1);
    }

    public static boolean givenSequenceExistsInATree(TreeNode root, List<Integer> currentPath, List<Integer> given_sequence) {
        if(root == null) return false;

        currentPath.add(root.data);

        if(root.left == null && root.right == null )
        {
            return given_sequence.equals(currentPath);
        }

        // check left side
        boolean left = givenSequenceExistsInATree(root.left, currentPath, given_sequence);
        boolean right = givenSequenceExistsInATree(root.right, currentPath, given_sequence);

        // since we have processed the current node and all its children we have to remove it from the currentPath
        currentPath.remove(currentPath.size()-1);

        return left || right;
    }

    public static boolean isGivenPathExistSimplified(TreeNode root, int index, List<Integer> list) {
        if(root == null || index >= list.size()) return false;
        // it means we are on a path which will never match with the input list.
        if(root.data != list.get(index)) {
            return  false;
        }
        if(root.data == list.get(index) && root.left == null && root.right == null){
            return  true;
        }
        boolean left = isGivenPathExistSimplified(root.left, index + 1, list);
        boolean right = isGivenPathExistSimplified(root.right, index + 1, list);
        return left || right;
    }

    public static int CountPathsForSum(TreeNode root, int sum) {
        if(root == null) return -1;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int sum_count = 0;
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
            boolean isSumExists = isSumExistsRecursive(node, sum);
            sum_count = isSumExists ? sum_count+1 : sum_count;
        }
        return sum_count;
    }


    public static int getDiameterOfTheTree(TreeNode node, AtomicInteger treeDiameter) {
        if(node == null) return 0;

        // get heights of left and right subtrees
        int left =  getDiameterOfTheTree(node.left, treeDiameter);
        int right = getDiameterOfTheTree(node.right, treeDiameter);

        // calculate the diametere through the current node (include the current node)
        int current_diameter = left + right +1;

        // update the tree diameter
        treeDiameter.set(Math.max(treeDiameter.get(), current_diameter));

        // It is imp to return the height of the subtree rooted at the current node
        return Math.max(left,right) +1; // +1 is to include the current node
    }

    // path with maximum sum
    private static int getpathMaxSumFromTheRoot(TreeNode node, AtomicInteger maxSumSoFar) {
        if(node == null) return  0;
        int left = node.data + getpathMaxSumFromTheRoot(node.left,maxSumSoFar);
        int right = node.data +  getpathMaxSumFromTheRoot(node.right,maxSumSoFar);

        // get the current path sum
        int currentPathSum = Math.max(left,right);

        maxSumSoFar.set(Math.max(maxSumSoFar.get(), currentPathSum));

        return currentPathSum;
    }

    private static int getpathMaxSumFromAnyNode(TreeNode node, AtomicInteger maxSumSoFar) {
        if(node == null) return  0;
        int left = getpathMaxSumFromTheRoot(node.left,maxSumSoFar);
        int right = getpathMaxSumFromTheRoot(node.right,maxSumSoFar);

        // get the current path sum including current node
        int currentPathSum = left + right + node.data;

        // set the max sum path so far
        maxSumSoFar.set(Math.max(maxSumSoFar.get(), currentPathSum));

        return Math.max(left,right) + node.data;
    }
}






















