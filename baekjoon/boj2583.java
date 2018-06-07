package baekjoon;

import java.io.*;
import java.util.*;

public class boj2583 {
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static ArrayList<Integer> area = new ArrayList<>();
    static int M, N;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            // 직사각형 채우기
            for (int j = startX; j < endX; j++) {
                for (int k = startY; k < endY; k++) {
                    map[j][k] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!map[i][j]) {
                    bfs(i, j, map);
                }
            }
        }

        Collections.sort(area);
        bw.write(area.size() + "\n");
        for (int i = 0; i < area.size(); i++) {
            bw.write(area.get(i) + " ");
        }
        bw.flush();
        br.close();
    }

    private static void bfs (int x, int y, boolean[][] map) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        map[x][y] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int length = q.size();
            for (int i = 0; i < length; i++) {
                Node node = q.poll();
                for (int j = 0; j < 4; j++) {
                    int sx = node.x + dx[j];
                    int sy = node.y + dy[j];

                    if (sx >= 0 && sx < N && sy >= 0 && sy < M && !map[sx][sy]) {
                        count++;
                        map[sx][sy] = true;
                        q.add(new Node(sx, sy));
                    }
                }
            }
        }

        area.add(count);
    }
}
