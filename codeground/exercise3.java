package codeground;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exercise3 {
    static int Answer;

    public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 0; test_case < T; test_case++) {
            Answer = 0;

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int score[] = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                score[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(score);

            for (int i = 0; i < K; i++) {
                Answer += score[N - i - 1];
            }
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}
