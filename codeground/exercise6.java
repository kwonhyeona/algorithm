package codeground;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class exercise6 {
    static int Answer;
    static Node position;
    static int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0}; // R, U, L, D
    static int[] dp, dp2;

    public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 0; test_case < T; test_case++) {
            Answer = 1;
            position = new Node(0, 0);
            String input[] = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);
            dp = new int[N];
            dp2 = new int[N];

            dp(N);

            String in = br.readLine();
            for (int i = 0; i < K; i++) {
                setPosition(in.charAt(i));
                calculate(N);
            }
            bw.write("Case #"+(test_case+1) + "\n");
            bw.write(Answer + "\n");
        }
        bw.flush();
    }

    private static void dp (int n) {
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int mod = (i % 2);
            if (mod == 0) { dp[i] = dp[i - 1] + 2 * i; }
            else { dp[i] = dp[i - 1] + 1; }
        }

        dp2[0] = dp[n - 1];
        int modN = (n % 2);
        for (int i = 1; i < n; i++) {
            int mod = (i % 2);
            switch (modN) {
                case 0:
                    if (mod == 0) { dp2[i] = dp2[i - 1] + 1; }
                    else { dp2[i] = dp2[i - 1] + (2 * n - 2 * i); }
                    break;
                case 1:
                    if (mod == 0) { dp2[i] = dp2[i - 1] + (2 * n - 2 * i); }
                    else { dp2[i] = dp2[i - 1] + 1; }
                    break;
            }
        }
    }

    private static void setPosition (char direction) {
        switch (direction) {
            case 'U': position.addX(dx[1]); position.addY(dy[1]); break;
            case 'D': position.addX(dx[3]); position.addY(dy[3]); break;
            case 'L': position.addX(dx[2]); position.addY(dy[2]); break;
            case 'R': position.addX(dx[0]); position.addY(dy[0]); break;
        }
    }

    private static void calculate (int n) {
        int add = position.getX() + position.getY();
        int roomNumber = 0;
        if (add >= n) {
            int diff = n - 1 - position.getY();
            int mod = ((position.getX() - diff) % 2);
            roomNumber = dp2[position.getX() - diff] + (mod == 1 ? diff : (-1) * diff);
        } else {
            if (add % 2 == 0) {
                // 짝수
                roomNumber = dp[add] - position.getX();
            } else {
                roomNumber = dp[add] + position.getX();
            }
        }
        Answer += roomNumber;
    }
}

class Node {
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addX(int x) {
        this.x += x;
    }

    public void addY(int y) {
        this.y += y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}