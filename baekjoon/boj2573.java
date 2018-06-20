package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2573 {
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static int M, N, total = 0;
    static int[][] map;
    static boolean[][] visited;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        Queue<Point> iceberg = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) iceberg.add(new Point(i, j, map[i][j]));
                total += map[i][j];
            }
        }

        bw.write(melt(iceberg) + "");
        bw.flush();
    }

    private static int melt (Queue<Point> iceberg) {
        int year = 0;
        while (!iceberg.isEmpty()) {
            if (total == 0) return 0;
            year++;
            int length = iceberg.size();
            for (int i = 0; i < length; i++) {
                Point node = iceberg.poll();
                int count = 0;
                for (int j = 0; j < 4; j++) {
                    int sx = node.x + dx[j];
                    int sy = node.y + dy[j];
                    if (sx >= 0 && sx < M && sy  >= 0 && sy < N && map[sx][sy] == 0) {
                        count++;
                    }
                }
                node.count = (map[node.x][node.y] - count < 0) ? 0 : map[node.x][node.y] - count;
                total -= count;
                iceberg.add(node);
            }
            for (int i = 0; i < length; i++) {
                Point node = iceberg.poll();
                map[node.x][node.y] = node.count;
                if (node.count != 0) iceberg.add(node);
            }

            if (checkDivision(iceberg.peek(), iceberg.size())) {
                break;
            }
        }

        return year;
    }

    private static boolean checkDivision (Point first, int size) {
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[M][N];
        visited[first.x][first.y] = true;
        q.add(first);

        int count = 1;
        while (!q.isEmpty()) {
            int length = q.size();
            for (int i = 0; i < length; i++) {
                Point ice = q.poll();
                for (int j = 0; j < 4; j++) {
                    int sx = ice.x + dx[j];
                    int sy = ice.y + dy[j];
                    if (sx >= 0 && sx < M && sy >= 0 && sy < N && !visited[sx][sy] && map[sx][sy] != 0) {
                        count++;
                        q.add(new Point(sx, sy));
                        visited[sx][sy] = true;
                    }
                }
            }
        }

        return (count != size);
    }
}