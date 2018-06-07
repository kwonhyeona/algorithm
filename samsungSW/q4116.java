package samsungSW;

import java.io.*;

public class q4116 {
    static int N;
    static String map[][];
    static int[] dx = { 0, 1 }, dy = { 1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int TESTCASE_COUNT = Integer.parseInt(br.readLine());

        for (int i = 0; i < TESTCASE_COUNT; i++) {
            N = Integer.parseInt(br.readLine());
            map = new String[N][N];

            for (int j = 0; j < N; j++) {
                String input = br.readLine();
                for (int k = 0; k < N; k++) {
                    map[j] = input.split("");
                }
            }

            int count = dfs(0, 0, map[0][0]);

            bw.write("#" + (i + 1) + " " + (count % 1000000007) + "\n");
        }

        bw.flush();
    }

    private static int dfs (int x, int y, String palindrome) {
        int count = 0;
        int length = palindrome.length();
        for (int i = 0; i < 2; i++) {
            int sx = x + dx[i], sy = y + dy[i];
            if (sx < N && sy < N) {
                if (length == 2 * N - 2) { return 1; }
                else if (length >= N) {
                    if (Character.toString(palindrome.charAt(2 * N - length - 2)).equals(map[sx][sy])) {
                        String palindrome2 = palindrome + map[sx][sy];
                        count += dfs(sx, sy, palindrome2);
                    }

                } else if (length < N) {
                    String palindrome2 = palindrome + map[sx][sy];
                    count += dfs(sx, sy, palindrome2);
                }
            }
        }

        return (count % 1000000007);
    }
}