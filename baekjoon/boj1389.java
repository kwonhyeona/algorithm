package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1389 {
    static int N, M, min = Integer.MAX_VALUE, index = 0;
    static int[][] kebin;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        kebin = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                kebin[i][j] = (i == j)? 0 : 1000000000;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            kebin[x][y] = kebin[y][x] = 1;
        }

        floyd();
        getMinKebin();
    }

    private static void floyd () {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (kebin[i][k] == 0) continue;
                for (int j = 0; j < N; j++) {
                    if (kebin[k][j] == 0) continue;
                    kebin[i][k] = Math.min(kebin[i][j], kebin[i][k] + kebin[k][j]);
                }
            }
        }
    }

    private static void getMinKebin () {
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += kebin[i][j];
            }
            if (min > sum) {
                index = i;
                min = sum;
            }
        }
        System.out.println(index + 1);
    }
}
