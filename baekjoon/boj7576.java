package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7576 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1 ,1};
    static int M, N, emptyCount = 0;
    static Queue<Node> q = new LinkedList<>();

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.add(new Node(i, j));
                    visited[i][j] = true;
                } else if (map[i][j] == -1) {
                    emptyCount++;
                }
            }
        }

        if (emptyCount == N * M || q.size() == N * M || emptyCount + q.size() == N * M) System.out.println(0);
        else if (emptyCount == 0 && q.size() == 0) System.out.println(-1);
        else System.out.print(bfs());
        br.close();
    }

    private static int bfs () {
        int count = 0;
        int ripenCount = q.size();
        while (!q.isEmpty()) {
            int length = q.size();
            for (int i = 0; i < length; i++) {
                Node tomato = q.poll();
                for (int j = 0; j < 4; j++) {
                    int sx = tomato.x + dx[j];
                    int sy = tomato.y + dy[j];
                    if (sx >= 0 && sx < M && sy >= 0 && sy < N && map[sx][sy] == 0 && !visited[sx][sy]) {
                        ripenCount++;
                        visited[sx][sy] = true;
                        q.add(new Node(sx, sy));
                    }
                }
            }
            count++;
            if (ripenCount == N * M - emptyCount) return count;
        }

        return -1;
    }
}
