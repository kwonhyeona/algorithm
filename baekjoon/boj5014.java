package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5014 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[F + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        visited[S] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int length = q.size();
            for (int i = 0; i < length; i++) {
                int current = q.poll();
                if (current == G) {
                    System.out.print(count);
                    return;
                }

                if (current + U <= F && !visited[current + U]) {
                    q.add(current + U);
                    visited[current + U] = true;
                }

                if (current - D >= 1 && !visited[current - D]) {
                    q.add(current - D);
                    visited[current - D] = true;
                }
            }
            count++;
        }

        System.out.print("use the stairs");
    }
}
