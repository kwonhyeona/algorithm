package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10026 {
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static short[][] map;
    static short[] count = new short[2];   // 0: 적녹색약x, 1: 적녹색약o
    static boolean[][] visited1, visited2; // 1: 적녹색약x, 2: 적녹색약o
    static int N;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new short[N][N];
        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String in = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = (short) in.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited1[i][j]) {
                    visited1[i][j] = true;
                    dfs(i, j, map[i][j], false);
                    count[0]++;
                }
                if (!visited2[i][j]) {
                    visited2[i][j] = true;
                    dfs(i, j, map[i][j], true);
                    count[1]++;
                }
            }
        }
        System.out.print(count[0] + " " + count[1]);
    }

    private static void dfs (int x, int y, int alpha, boolean isRedGreenPerson) {
        for (int i = 0; i < 4; i++) {
            int sx = x + dx[i], sy = y + dy[i];
            if (sx >= 0 && sx < N && sy >= 0 && sy < N) {
                if (isRedGreenPerson && !visited2[sx][sy]) {
                    // 적녹색약이면서 아직 방문하지 않은 노드일 경우
                    if (((alpha == 'B') && (map[sx][sy] == 'B')) || ((alpha != 'B') && (map[sx][sy] != 'B'))) {
                        visited2[sx][sy] = true;
                        dfs(sx, sy, alpha, isRedGreenPerson);
                    }
                } else if (!isRedGreenPerson && !visited1[sx][sy]) {
                    // 적녹색약이 아니면서 아직 방문하지 않은 노드일 경우
                    if (alpha != map[sx][sy]) continue;
                    visited1[sx][sy] = true;
                    dfs(sx, sy, alpha, isRedGreenPerson);
                }
            }
        }
    }
}
