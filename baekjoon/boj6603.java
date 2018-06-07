package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj6603 {
    static int T;
    static int[] list;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            if (T == 0) break;

            list = new int[T];
            visited = new boolean[T];
            sb = new StringBuilder();

            for (int i = 0; i < T; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }

            calculate(0, 0);
            System.out.println(sb);
        }
        br.close();
    }

    private static void calculate (int v, int length) {
        if (length == 6) {
            for (int i = 0; i < T; i++) {
                if (visited[i]) sb.append(list[i] + " ");
            }
            sb.append("\n");
            return;

        }
        if (v >= T) return;

        visited[v] = true;
        calculate(v + 1, length + 1); // 이번 인덱스를 포함하는 경우
        visited[v] = false;
        calculate(v + 1, length); // 이번 인덱스를 포함하지 않는 경
    }
}