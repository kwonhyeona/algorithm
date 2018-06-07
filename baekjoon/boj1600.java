package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1600 {
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = { 1, -1, 0, 0, 2, 2, -2, -2, 1, 1, -1, -1 };
    static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1, 2, -2, 2, -2 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        visited = new boolean[H][W][K + 1];
        map = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) { visited[0][0][i] = true; }

        if (W == 1 && H == 1) System.out.print(0);
        else System.out.print(bfs());
        br.close();
    }

    private static int bfs () {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0));
        int time = 0;


        while (!q.isEmpty()) {
            int length = q.size();
            for (int i = 0; i < length; i++) {
                Point p = q.poll();
                if (p.x == H - 1 && p.y == W - 1) return time;

                for (int j = 0; j < 12; j++) {
                    int sx = p.x + dx[j], sy = p.y + dy[j];
                    if (!(sx >= 0 && sx < H && sy >= 0 && sy < W && map[sx][sy] == 0)) continue;

                    if (j < 4) {
                        if (!visited[sx][sy][p.count]) {
                            visited[sx][sy][p.count] = true;
                            q.add(new Point(sx, sy, p.count));
                        }
                    } else {
                        int nextCount = p.count + 1;
                        if (nextCount <= K && !visited[sx][sy][nextCount]) {
                            visited[sx][sy][nextCount] = true;
                            q.add(new Point(sx, sy, nextCount));
                        }
                    }
                }

            }
            time++;
        }

        return -1;
    }
}

class Point {
    int x;     // x좌표
    int y;     // y좌표
    int count; // 몇번 말처럼 움직였는지

    public Point(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}