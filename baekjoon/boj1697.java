package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1697 {
    static int N, K;
    static boolean[] visited = new boolean[100001];

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) System.out.print(N - K);
        else System.out.print(bfs());
    }

    private static int bfs () {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        int count = 0;
        visited[N] = true;

        while (!q.isEmpty()) {
            int length = q.size();
            for (int i = 0; i < length; i++) {
                int point = q.poll();
                if (point == K) return count;

                if (point < K) {
                    if (point <= 100000 && !visited[point + 1]) {
                        visited[point + 1] = true;
                        q.add(point + 1);
                    }
                    if (point * 2 <= 100000 && !visited[point * 2]) {
                        visited[point * 2] = true;
                        q.add(point * 2);
                    }
                }

                if (1 <= point && !visited[point - 1]) {
                    visited[point - 1] = true;
                    q.add(point - 1);
                }
            }
            ++count;
        }

        return 0;
    }
}