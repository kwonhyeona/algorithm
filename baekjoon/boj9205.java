package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj9205 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            ArrayList<Node> position = new ArrayList<>();
            boolean[] visited = new boolean[n + 2];

            for (int j = 0; j < n + 2; j++) {
                st = new StringTokenizer(br.readLine());
                position.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            Queue<Node> q = new LinkedList<>();
            q.add(position.get(0));
            visited[0] = true;
            boolean flag = false;

            while (!q.isEmpty()) {
                Node current = q.poll();
                if (current.equals(position.get(n + 1))) {
                    flag = true;
                    break;
                }

                for (int j = 1; j < n + 2; j++) {
                    int distance = Math.abs(current.x - position.get(j).x) + Math.abs(current.y - position.get(j).y);
                    if (!visited[j] && distance <= 1000) {
                        visited[j] = true;
                        q.add(position.get(j));
                    }
                }
            }

            bw.write(flag ? "happy\n" : "sad\n");
        }
        bw.flush();
        br.close();
    }
}
