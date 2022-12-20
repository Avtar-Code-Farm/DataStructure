package Patterns.Tree.BFS;

import Patterns.Tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class BFSTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        printLevelWiseBFS(root);
        printLevelOrderLinebyLine(root);
        printeLevelWise_Simplified_BFS(root);
        System.out.println(root);
        printPreOrder_DLR(root);
        System.out.println(root);
        printInOrder_DLR(root);
        printBottomUpLevelOrder(root);
        printZigZag(root);

        List<Double> res = getAvgByLevel(root);

        TreeNode n = findLevelOrderNextSuccessor(root, 3);
        TreeNode level_order = connectLevelOrderNodes(root);
        TreeNode level_order_sibiling = ConnectAllLevelOrderSiblings(root);
        PrintRightViewOfTree(root);
    }
                // 1
            //  2        3
        //   4     5    6   7

    private static void printPreOrder_DLR(TreeNode node){
        // first print the root and then keep the right in the stack and continue in the left

        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || node != null) {
            if(node != null) {
                System.out.print("  " + node.data);
                if(node.right != null) stack.push(node.right);
                node = node.left;
            }
            else
                node = stack.pop();
        }
    }

    private static void printInOrder_DLR(TreeNode node){

        // move the left most first node. while moving keep adding the node right into the stack
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || node != null) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()) {
                node = stack.pop();
                System.out.print("  " + node.data);
                node = node.right;
            }
        }
    }

    private static void printLevelOrderLinebyLine(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList();
        Queue<TreeNode> q2 = new LinkedList();
        q1.add(root);
        System.out.println(" Level by level");
        while(!q1.isEmpty() || !q2.isEmpty()) {
            while(!q1.isEmpty()) {
                TreeNode temp = q1.poll();
                System.out.print(" " + temp.data);
                if(temp.left != null) q2.add(temp.left);
                if(temp.right != null) q2.add(temp.right);
            }
            System.out.println();
            while(!q2.isEmpty()) {
                TreeNode temp = q2.poll();
                System.out.print(" " + temp.data);
                if(temp.left != null) q1.add(temp.left);
                if(temp.right != null) q1.add(temp.right);
            }
            System.out.println();
        }
    }

    private static void printLevelWiseBFS(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();

        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.println(" " + node.data);
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
    }

    // we will use level size to process all notes at the current level
    private static void printeLevelWise_Simplified_BFS(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        int queueSize = 0;
        q.add(root);
        System.out.println("printeLevelWise_Simplified_BFS");
        System.out.println();
        while(!q.isEmpty()) {
            queueSize = q.size();
            while(queueSize > 0) {
                TreeNode node = q.poll();
                System.out.print(" " + node.data);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                queueSize--;
            }
            System.out.println();
        }
        System.out.println("printeLevelWise_Simplified_BFS");
    }

    private static void printBottomUpLevelOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Pope from the queue -> current
        //      add current.right into the queue
        //      add current.left into the queue
        // add the current into the stack;
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if(current.right != null) queue.add(current.right);
            if(current.left != null) queue.add(current.left);
            stack.push(current);
        }
        System.out.println();
        System.out.println(" printBottomUpLevelOrder ");
        while(!stack.isEmpty()) {
            System.out.println("  " + stack.pop().data);
        }
    }

    // Use two stack s1 and s2
    // keep poping from s1 and at odd level add left to right
    // keep popeing from s2 and  at even level add right to left
    // https://www.ideserve.co.in/learn/spiral-level-order-traversal-of-a-binary-tree-set-1
    private static void printZigZag(TreeNode node) {
         int level = -1;
         Stack<TreeNode> s1 = new Stack<>(); // add element right and then left;
         Stack<TreeNode> s2 = new Stack<>(); // add element left and then right

         s1.push(node);
         System.out.println("printZigZag");
        List<List<Integer>> result = new ArrayList<List<Integer>>();
         while(!s1.isEmpty() || !s2.isEmpty()) {

             while(!s1.isEmpty()) {
                 TreeNode temp = s1.pop();
                 System.out.println(temp.data);
                 if(temp.left != null) s2.push(temp.left);
                 if(temp.right != null) s2.push(temp.right);
             }
             while(!s2.isEmpty()) {
                 TreeNode temp = s2.pop();
                 System.out.println(temp.data);
                 if(temp.right != null) s1.push(temp.right);
                 if(temp.left != null) s1.push(temp.left);
             }
         }
    }



    public static List<Double> getAvgByLevel(TreeNode node) {
        List<Double> result = new ArrayList<>();
        if(node == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        double level_sum =0;
        q.offer(node);

        while(!q.isEmpty()) {
            level_sum = 0;
            int size = q.size();
            for(int i = 0; i < size; i ++) {
                TreeNode cur = q.poll();
                level_sum += cur.data;
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            double avg = level_sum / size;
            result.add(avg);
        }
        return result;
    }

    private static TreeNode findLevelOrderNextSuccessor(TreeNode root, int key ) {
        TreeNode result = null;
        if(root == null) return result;
        if(root.left == null && root.right == null) return result;

        boolean nodeFound = false;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {

            int size = q.size();
            for(int i = 0; i < size; i ++) {
                TreeNode cur = q.poll();

                if(nodeFound) {
                    return cur;
                }

                if(cur.data == key) {
                    nodeFound = true;
                }

                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
        }
        return null;
    }

    private static TreeNode connectLevelOrderNodes(TreeNode root) {
        if(root == null) return root;
        if(root.left == null && root.right == null) return root;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {

            int size = q.size();
            TreeNode cur, prev = null;
            for(int i = 0; i < size; i ++) {
                cur = q.poll();

                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);

                // connect nodes;
                if(prev != null) {
                    prev.next = cur;
                }
                prev = cur;
            }
        }
        return root;
    }

    private static TreeNode ConnectAllLevelOrderSiblings(TreeNode root) {
        if(root == null) return root;
        if(root.left == null && root.right == null) return root;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode  prev = root;
        while(!q.isEmpty()) {

            int size = q.size();
            TreeNode cur = null;
            for(int i = 0; i < size; i ++) {
                cur = q.poll();

                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);

                // connect nodes;
                prev.next = cur;
                prev = cur;
            }
        }
        return root;
    }

    private static void PrintRightViewOfTree(TreeNode root) {
        if(root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode lastNode = null;
        while(!q.isEmpty()) {

            int size = q.size();
            TreeNode cur = null;
            for(int i = 0; i < size; i ++) {
                cur = q.poll();

                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
                lastNode = cur;
            }
            System.out.println("Right side view " + lastNode.data);
        }
    }

}
