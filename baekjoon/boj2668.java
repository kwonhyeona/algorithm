package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj2668 {
    static int[] map;
    static boolean[] visited;
    static int last, count = 0;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            last = i;
            DFS(i);
            visited[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int i : list) {
            System.out.println(i);
        }
    }

    private static void DFS(int i) {
        if (!visited[map[i]]) {
            visited[map[i]] = true;
            DFS(map[i]);
            visited[map[i]] = false;
        }
        if (map[i] == last) {
            list.add(last);
        }
    }
}
