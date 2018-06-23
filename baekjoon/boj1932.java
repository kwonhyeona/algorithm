package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1932 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int stairs = Integer.parseInt(st.nextToken());
        int[][] map = new int[stairs][stairs];
        int[][] dp = new int[stairs][stairs];
        for (int i = 0; i < stairs; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = map[0][0];
        dp[1][0] = map[1][0] + dp[0][0];
        dp[1][1] = map[1][1] + dp[0][0];

        int max = -1;
        for (int i = 2; i < stairs; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j - 1 < 0) dp[i][j] = dp[i - 1][j] + map[i][j];
                else if (j == i) dp[i][j] = dp[i - 1][j - 1] + map[i][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + map[i][j];

                if (i == stairs - 1) max = Math.max(max, dp[i][j]);
            }
        }

        System.out.print(max);
    }
}
