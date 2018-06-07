package codeground;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class exercise2 {
    static int Answer;

    public static void main(String args[]) throws Exception	{
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());
        for(int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(sc.nextLine().trim());
            int MAX = 0;
            Answer = 0;
            int arr[] = new int[N];
            int[] next = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(sc.nextLine());
            }

            Arrays.sort(arr);

            for (int i = 0; i < N; i++) {
                next[i] = arr[i] + (N - i);
                MAX = Math.max(next[i], MAX);
            }

            for (int i = 0; i < N; i++){
                if (arr[i] >= (MAX - N)) {
                    Answer++;
                }
            }

            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}
