package edu.princeton.cs.point;

import java.util.Arrays;

/**
 * @description: 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * <p>
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * <p>
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 * @author: cheng kai
 * @create: 2021-03-04 15:23
 **/
public class FindTwoNumsOnlyAppearOnceInArray2 {

    /**
     * 位运算 + 有限状态自动机
     *
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }

        return ones;
    }

    public static void main(String[] args) {
        int[] nums = {9,1,7,9,7,9,7};

        System.out.println("The num only appear once is " + solution(nums));
    }

}
