package edu.princeton.cs.point;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 剑指 Offer 32 - I. 从上到下打印二叉树（按层打印二叉树）
 * <p>
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 提示：节点总数 <= 1000
 * <p>
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * @author: cheng kai
 * @create: 2021-02-22 15:42
 **/
public class PrintBinaryTreeByLevel {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int[] solution(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        List<Integer> tempVales = new LinkedList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            tempVales.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        int[] values = new int[tempVales.size()];
        for (int i = 0; i < values.length; i++) {
            values[i] = tempVales.get(i);
        }

        return values;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        System.out.println("Print binary tree by level: " + Arrays.toString(solution(root)));
    }
}
