package edu.princeton.cs.classic;

/**
 * @description: 面试题 01.01. 判定字符是否唯一
 * <p>
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * 如果你不使用额外的数据结构，会很加分。
 * <p>
 * https://leetcode-cn.com/problems/is-unique-lcci/
 * @author: cheng kai
 * @create: 2021-03-08 16:01
 **/
public class IsCharUniqueInString {

    /**
     * 辅助数组
     *
     * @param astr
     * @return
     */
    public static boolean solution(String astr) {
        int[] arr = new int[128];
        for (int i = 0; i < astr.length(); i++) {
            //把字符和数组关联
            if (arr[astr.charAt(i)] != 0) {
                return false;
            }
            arr[astr.charAt(i)]++;
        }
        return true;
    }

    public static void main(String[] args) {
        String astr = "LeetCode";
        System.out.println("Is char unique in the string? " + solution(astr));
    }
}
