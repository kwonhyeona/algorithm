package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10844 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.print(9);
            return;
        }
        int[] dp = new int[n + 1];
        dp[1] = 9;
        dp[2] = 17;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2 - 2) % 1000000000;
        }

        System.out.print(dp[n]);
    }
}