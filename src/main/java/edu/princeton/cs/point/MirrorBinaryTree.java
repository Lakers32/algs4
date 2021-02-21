package edu.princeton.cs.point;

/**
 * @description: 剑指 Offer 27. 二叉树的镜像
 * @author: cheng kai
 * @create: 2021-02-21 16:38
 **/
public class MirrorBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode solution (TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftTemp = root.left;
        root.left = solution(root.right);
        root.right = solution(leftTemp);
        
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        solution(root);
        System.out.println();
    }
}
