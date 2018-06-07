package baekjoon;

import java.io.*;
import java.util.*;

public class boj1012 {
    static int M, N, K;
    static boolean[][] visited, field;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            visited = new boolean[M][N];
            field = new boolean[M][N];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                field[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
            }

            int count = 0;
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (field[x][y] && !visited[x][y]) {
                        bfs(x, y);
                        count++;
                    }
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        br.close();
    }

    private static void bfs (int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int sx = node.x + dx[i];
                int sy = node.y + dy[i];
                if (sx >= 0 && sx < M && sy >= 0 && sy < N && !visited[sx][sy] && field[sx][sy]) {
                    visited[sx][sy] = true;
                    q.add(new Node(sx, sy));
                }
            }
        }
    }
}
