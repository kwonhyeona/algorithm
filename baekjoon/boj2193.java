package baekjoon;

import java.util.Scanner;

public class boj2193 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n + 1];
        if (n == 1) {
            System.out.print(1);
            return;
        }
        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.print(dp[n]);
    }
}
