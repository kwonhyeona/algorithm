package baekjoon;

import java.io.*;

public class boj2748 {
    public static void main (String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        if (n == 0) System.out.println(0);
//        else if (n == 1) System.out.println(1);
//        else {
//            long a = 0;
//            long b = 1;
//
//            for (int i = 1; i < n; i++) {
//                long sum = a + b;
//                a = b;
//                b = sum;
//            }
//            System.out.println(b);
//        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];

        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        bw.write(dp[n] + "");
        bw.flush();
        br.close();
    }
}
