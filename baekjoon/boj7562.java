package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7562 {
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1}, dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static boolean[][] visited;
    static Node destination;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int L = Integer.parseInt(br.readLine());
            visited = new boolean[L][L];
            st = new StringTokenizer(br.readLine());
            Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            destination = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            bw.write(bfs(start, L) + "\n");
        }

        bw.flush();
        br.close();
    }

    private static int bfs (Node start, int size) {
        if ((start.x == destination.x) && (start.y == destination.y)) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = true;

        int count = 0;

        while (!q.isEmpty()) {
            count++;
            int length = q.size();
            for (int i = 0; i < length; i++) {
                Node current = q.poll();

                for (int j = 0; j < 8; j++) {
                    int sx = current.x + dx[j];
                    int sy = current.y + dy[j];

                    if (sx >= 0 && sx < size && sy >= 0 && sy < size && !visited[sx][sy]) {
                        if (sx == destination.x && sy == destination.y) {
                            return count;
                        }
                        visited[sx][sy] = true;
                        q.add(new Node(sx, sy));

                    }
                }
            }
        }

        return 0;
    }
}
