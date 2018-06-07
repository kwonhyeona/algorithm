package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1149 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int previousR = dp[0], previousG = dp[1], previousB = dp[2];
            int costR = Integer.parseInt(st.nextToken()), costG = Integer.parseInt(st.nextToken()), costB = Integer.parseInt(st.nextToken());
            dp[0] = costR + Math.min(previousG, previousB);
            dp[1] = costG + Math.min(previousR, previousB);
            dp[2] = costB + Math.min(previousR, previousG);
        }

        System.out.print(Math.min(dp[0], Math.min(dp[1], dp[2])));
    }
}
