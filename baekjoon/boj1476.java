package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1476 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken()); // 1 <= E <= 15
        int S = Integer.parseInt(st.nextToken()); // 1 <= S <= 28
        int M = Integer.parseInt(st.nextToken()); // 1 <= M <= 19

        int year = S;
        while (true) {
            if (((year - 1) % 15 + 1 == E) && ((year - 1) % 19 + 1 == M)) {
                System.out.println(year);
                break;
            }
            year += 28;
        }
        br.close();
    }
}
