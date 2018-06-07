package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14500 {
    static int N, M, MAX = 0;
    static int[][] map, visited;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N][M];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N * M; i++) {
            int x = i / M;
            int y = i % M;
            visited[x][y] = 1;
            dfs(x, y, 1, map[x][y]);
            CalculateSpecialBlock(x, y);
            visited[x][y] = 0;
        }
        System.out.println(MAX);
    }

    private static void dfs (int x, int y, int count, int sum) {
        if (count == 4) {
            MAX = Math.max(MAX, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int sx = x + dx[i];
            int sy = y + dy[i];

            if (sx >= 0 && sx < N && sy >= 0 && sy < M && visited[sx][sy] == 0) {
                visited[sx][sy] = 1;
                dfs(sx, sy, count + 1, sum + map[sx][sy]);
                visited[sx][sy] = 0;
            }
        }
    }

    private static void CalculateSpecialBlock (int x, int y) {
        for (int i = 0; i < 4; i++) {
            int total = map[x][y];
            boolean flag = true;

            for (int j = 0; j < 3; j++) {
                int sx = x + dx[(i + j) % 4];
                int sy = y + dy[(i + j) % 4];

                if (sx >= 0 && sx < N && sy >= 0 && sy < M) {
                    total += map[sx][sy];
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag) MAX = Math.max(MAX, total);
        }
    }
}
