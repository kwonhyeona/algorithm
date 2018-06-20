package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2178 {
    static int N, M, COUNT = 0;
    static int visit[][];
    static int map[][];
    static int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new int[N][M];
        map = new int[N][M];

        // 입력받기
        for (int i = 0; i < N; i++) {
            String input[] = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs();

        System.out.println(COUNT + 1);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            COUNT++;
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                for (int j = 0; j < 4; j++) {
                    int sx = node.x + dx[j];
                    int sy = node.y + dy[j];
                    if (sx >= 0 && sx < N && sy >= 0 && sy < M && visit[sx][sy] == 0 && map[sx][sy] == 1) {
                        if (sx == (N - 1) && sy == (M - 1)) return;
                        visit[sx][sy] = 1;
                        q.offer(new Node(sx, sy));
                    }
                }
            }
        }
    }
}
