package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1652 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] count = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] input = st.nextToken().split("");
            for (int j = 0; j < N; j++) {
                if (input[j].equals(".")) {
                    count[i][0]++;
                    count[j][1]++;
                }
            }
        }

        int horizontal = 0, vertical = 0;
        for (int i = 0; i < N; i++) {
            if (count[i][0] >= 2) horizontal++;
            if (count[i][1] >= 2) vertical++;
        }

        System.out.println(horizontal + " " + vertical);
    }
}
