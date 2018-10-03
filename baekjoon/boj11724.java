package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연결 요소의 개수
public class boj11724 {
    private static int count = 1, N;
    private static int[][] map;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = map[y][x] = 1;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                ++count;
                dfs(i);
            }
        }

        System.out.print(count - 1);
    }

    public static void dfs(int current) {
        for (int i = 0; i < N; i++) {
            if(!visited[i] && map[current][i] == 1) {
                visited[i] = true;
                map[current][i] = map[i][current] = count;
                dfs(i);
            }
        }
    }
}
