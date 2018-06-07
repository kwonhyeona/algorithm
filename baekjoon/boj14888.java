package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj14888 {
    static int N, MIN = Integer.MAX_VALUE, MAX = Integer.MIN_VALUE;
    static int[] number;
    static boolean[] visited;
    static ArrayList<Integer> operations = new ArrayList<>();

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        number = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                operations.add(i);
            }
        }

        backTracking(0, 0, number[0], 1);
        bw.write(MAX + "\n" + MIN);
        bw.flush();

    }

    private static void backTracking (int v, int length, int num, int index) {
        if (length == N - 1) {
            MIN = Math.min(MIN, num);
            MAX = Math.max(MAX, num);
        } else {
            int result = 0;
            for (int i = 0; i < N - 1; i++) {
                if (!visited[i]) {

                    switch (operations.get(i)) {
                        case 0: result = num + number[index]; break;
                        case 1: result = num - number[index]; break;
                        case 2: result = num * number[index]; break;
                        case 3: result = num / number[index]; break;
                    }
                    visited[i] = true;
                    backTracking(i, length + 1, result, index + 1);
                }
            }
        }
        visited[v] = false;
    }
}
