package codeground;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class exercise5 {
    static int Answer;
    static int MOD_INT = 1_000_000_007;
    static int[] dp, dp2;

    public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 0; test_case < T; test_case++) {
            Answer = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            dp = new int[Math.max(N, M) + 1];
            dp2 = new int[Math.max(N, M) + 1];

            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= M; j++) {
                    Answer += factorial(i + j) / (factorial(i) * factorial(j) % MOD_INT);
                }
            }
            bw.write("Case #"+ (test_case+1) + "\n");
            bw.write(Answer + "\n");
        }
        bw.flush();
    }

    private static int factorial (int number) {
        if (number <= 1) return 1;
        if (number < dp.length && dp[number] != 0) return dp[number];

        int result = number * factorial(number - 1) % MOD_INT;
        if (number < dp.length) dp[number] = result;
        return result;
    }

    private static int factorial (int number, int lastNumber) {
        if (number <= 1) return 1;
        if (number <= lastNumber) return 1;

        int result = number * factorial(number - 1, lastNumber);
        return (result > 0 ? result : result % MOD_INT);
    }
}
