package edu.princeton.cs.point;

/**
 * @description: 剑指 Offer 49. 丑数
 * <p>
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 * @author: cheng kai
 * @create: 2021-03-02 10:59
 **/
public class NthUglyNumber {

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static int solution (int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) {
                a++;
            }
            if(dp[i] == n3) {
                b++;
            }
            if(dp[i] == n5) {
                c++;
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("The " + n + "th ugly number is " + solution(n));
    }
}
