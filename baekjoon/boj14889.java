package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj14889 {
    static int N, min = Integer.MAX_VALUE;
    static int[][] ability;
    static boolean[] isDecidedTeam;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ability = new int[N + 1][N + 1];
        isDecidedTeam = new boolean[N + 1];

        // 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 0);

        System.out.println(min);
    }

    private static void backTracking (int row, int length) {
        if (length == N / 2) { compareAbility(); }
        else {
            for (int i = row + 1; i < N; i++) {
                if (!isDecidedTeam[i]) {
                    isDecidedTeam[i] = true;
                    backTracking(i, length + 1);
                }
            }
        }
        isDecidedTeam[row] = false;
    }

    private static void compareAbility () {
        ArrayList<Integer> teamA = new ArrayList<>();
        ArrayList<Integer> teamB = new ArrayList<>();
        int totalA = 0, totalB = 0;

        for (int i = 0; i < N; i++) {
            if (isDecidedTeam[i]) teamA.add(i);
            else teamB.add(i);
        }

        for (int i = 0; i < N / 2; i++) {
            int memberA = teamA.get(i);
            int memberB = teamB.get(i);

            for (int j = 0; j < N / 2; j++) {
                int tempA = teamA.get(j);
                int tempB = teamB.get(j);
                totalA += ability[memberA][tempA];
                totalB += ability[memberB][tempB];
            }
        }
        min = Math.min(min, Math.abs(totalA-totalB));
    }
}
