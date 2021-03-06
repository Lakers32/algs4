package edu.princeton.cs.point;

/**
 * @description: 剑指 Offer 65. 不用加减乘除做加法
 * <p>
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * @author: cheng kai
 * @create: 2021-03-06 14:51
 **/
public class AddTwoNumsWithCondition {

    public static int solution(int a, int b) {
        // 当进位为 0 时跳出
        while (b != 0) {
            // c = 进位
            int c = (a & b) << 1;
            // a = 非进位和
            a ^= b;
            // b = 进位
            b = c;
        }

        return a;
    }

    public static void main(String[] args) {
        int a = 3, b = -8;
        System.out.println("The two nums sum is " + solution(a, b));
    }
}
