package edu.princeton.cs.point;

/**
 * @description: 剑指 Offer 42. 连续子数组的最大和
 * <p>
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * <p>
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * @author: cheng kai
 * @create: 2021-02-25 16:48
 **/
public class MaxSubArray {


    /**
     * 暴力法
     *
     * @param a
     * @return
     */
    public static int solution1(int[] a) {
        int maxSum = 0;

        for (int i = 0; i < a.length; i++) {
            int tempSum = 0;

            for (int j = i; j < a.length; j++) {
                tempSum += a[j];

                if (tempSum > maxSum) {
                    maxSum = tempSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * 分治法
     * 在一个数组中要找到最大连续子序列和，这个和要么出现在左半部分，要么出先在右半部分，要么出现在横跨两部分之间。
     *
     * @param a
     * @return
     */
    public static int solution2(int[] a) {
        return solution2(a, 0, a.length - 1);
    }

    private static int solution2(int[] a, int left, int right) {
        if (left == right) {
            if (a[left] > 0) {
                return a[left];
            } else {
                return 0;
            }
        }

        int center = (left + right) / 2;
        int maxLeftSum = solution2(a, left, center);
        int maxRightSum = solution2(a, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        return Math.max(Math.max(maxLeftSum, maxRightSum), maxLeftBorderSum + maxRightBorderSum);
    }

    /**
     * 动态规划1
     * 开辟数组存储当前的最大子序列和
     *
     * @param nums
     * @return
     */
    public static int solution31(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int j = 1; j < nums.length; j++) {
            if (dp[j - 1] > 0) {
                dp[j] = dp[j - 1] + nums[j];
            } else {
                dp[j] = nums[j];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    /**
     * 动态规划2
     * 总体来说，最大值在 (sum[i-1], nums[i], sum[i-1] + nums[i]) 中决出
     * ①、若sum[i-1] > 0, 则最大值在 (sum[i-1], sum[i-1] + nums[i] )中决出
     * ②、若sum[i-1] < 0, 则最大值在 (sum[i-1], nums[i])中决出
     *
     * @param nums
     * @return
     */
    public static int solution32(int[] nums) {
        int maxSum = nums[0];
        // 用于记录dp[i-1]的值，对于dp[0]而言，其前面的dp[-1]=0
        int previousSum = 0;
        // 用于记录dp[i]的值
        int candidateSumMax;
        for (int num : nums) {
            candidateSumMax = num;
            if (previousSum > 0) {
                candidateSumMax += previousSum;
            }
            if (candidateSumMax > maxSum) {
                maxSum = candidateSumMax;
            }
            previousSum = candidateSumMax;
        }

        return maxSum;
    }

    /**
     * 动态规划3
     * 覆盖数值原值，极省空间
     *
     * @param nums
     * @return
     */
    public static int solution33(int[] nums) {
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            maxSum = Math.max(maxSum, nums[i]);
        }

        return maxSum;
    }


    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {-2, -1, -3, -4};

        System.out.println("The max of sub array is " + solution2(nums));
    }
}
