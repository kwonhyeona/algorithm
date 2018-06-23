package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2579 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] dp = new int[count + 1];
        int[] score = new int[count + 1];

        for (int i = 1; i <= count; i++) score[i] = Integer.parseInt(br.readLine());

        dp[1] = score[1];
        dp[2] = dp[1] + score[2];
        dp[3] = Math.max(score[1], score[2]) + score[3];

        for (int i = 4; i <= count; i++) {
            dp[i] = Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
        }

        System.out.print(dp[count]);
        br.close();
    }
}
