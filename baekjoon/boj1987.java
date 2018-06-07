package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1987 {
    static int R, C;
    static int[][] alpha;
    static boolean[][] visited;
    static boolean[] check = new boolean[26];
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        alpha = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String in = br.readLine();
            for (int j = 0; j < C; j++) {
                alpha[i][j] = in.charAt(j) - 'A';
            }
        }

        visited[0][0] = true;
        check[alpha[0][0]] = true;
        System.out.print(dfs(0, 0));
    }

    private static int dfs (int x, int y) {
        int cnt = 0;
        for (int i = 0 ; i < 4; i++) {
            int sx = x + dx[i], sy = y + dy[i];
            if (sx >= 0 && sx < R && sy >= 0 && sy < C && !visited[sx][sy]) {
                if (!check[alpha[sx][sy]]) {
                    visited[sx][sy] = true;
                    check[alpha[sx][sy]] = true;
                    cnt = Math.max(cnt, dfs(sx, sy));
                    visited[sx][sy] = false;
                }
            }
        }

        check[alpha[x][y]] = false;
        return cnt + 1;
    }
}
