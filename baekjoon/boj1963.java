package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1963 {
    static boolean[] prime = new boolean[10001];
    static boolean[] check;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TESTCASE_COUNT = Integer.parseInt(st.nextToken());
        findPrime();
        for (int i = 0; i < TESTCASE_COUNT; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            check = new boolean[9000];
            bfs(start, destination);
        }
    }

    private static void findPrime () {
        for (int i = 2; i < 10000; i++) {
            if (prime[i]) continue;
            for (int j = i + i; j <= 10000; j += i) prime[j] = true;
        }
    }

    private static void bfs (int start, int destination) {
        if (start == destination) {
            System.out.println(0);
            return;
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        check[start - 1000] = true;

        while (!q.isEmpty()) {
            count++;
            int length = q.size();
            for (int k = 0; k < length; k++) {
                int current = q.poll();
                int division = current;
                for (int i = 3; i >= 0; i--) {
                    int pow = (int) Math.pow(10, i);
                    int num = current - (division / pow) * pow;
                    division = division % pow;
                    for (int j = 0; j < 10; j++) {
                        if (pow == 1000 && j == 0) continue;
                        int compare = num + pow * j;
                        if (compare == destination) {
                            System.out.println(count);
                            return;
                        }
                        if (!check[compare - 1000] && !prime[compare]) {
                            check[compare - 1000] = true;
                            q.add(compare);
                        }
                    }
                }
            }
        }

        System.out.println("Impossible");
    }
}
