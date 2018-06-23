package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1652 {
    static boolean[][] map;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        map = new boolean[N][N];
        int horizontal = 0, vertical = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] input = st.nextToken().split("");
            boolean flag = false;

            for (int j = 0; j < N; j++) {
                map[i][j] = (input[j].equals("."));
                if (j > 0 && !flag && map[i][j - 1] && map[i][j]) {
                    horizontal++;
                    flag = true;
                }

                if (!map[i][j]) flag = false;
            }
        }

        for (int i = 0; i < N; i++) {
            boolean flag = false;

            for (int j = 0; j < N; j++) {
                if (j > 0 && !flag && map[j - 1][i] && map[j][i]) {
                    vertical++;
                    flag = true;
                }

                if (!map[j][i]) flag = false;
            }
        }

        System.out.print(horizontal + " " + vertical);
    }
}
