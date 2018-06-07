package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0] = Integer.parseInt(st.nextToken());
        int max = dp[0];
        for (int i = 1; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i - 1] + input, input);
            max = Math.max(max, dp[i]);
        }
        System.out.print(max);
    }
}
