package baekjoon;

import java.util.Scanner;

public class boj11726 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getCount(n));
    }

    public static int getCount (int n) {
        if (n < 2) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            // (i - 1)칸까지 채우고 세로로 블럭 하나 놓는 경우의 수
            // (i - 2)칸까지 채우고 가로로 블럭 두개 놓는 경우의 수
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        return dp[n];
    }
}
