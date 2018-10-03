package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 경로 찾기
public class boj11403 {
    private static int N;
    private static int[][] input, path;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        input = new int[N][N];
        path = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int start = 0; start < N; start++) {
            visited = new boolean[N];
            dfs(start, start);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(path[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int start, int mid) {
        for(int i = 0; i < N; i++) {
            if(input[mid][i] == 1 && !visited[i]) {
                path[start][i] = 1;
                visited[i] = true;
                dfs(start, i);
            }
        }
    }
}
