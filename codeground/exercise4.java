package codeground;

import java.util.Scanner;

public class exercise4 {
    static int Answer;

    public static void main(String args[]) throws Exception	{
        Scanner sc = new Scanner(System.in);

        int score[] = {13, 4, 18, 1, 20, 5, 12, 9, 14, 11, 8, 16, 7, 19, 3, 17, 2, 15, 10, 6};
        int T = Integer.parseInt(sc.nextLine());
        for(int test_case = 0; test_case < T; test_case++) {
            int[] radius = new int[5];
            Answer = 0;

            String input[] = sc.nextLine().split(" ");
            for (int i = 0; i < 5; i++) {
                radius[i] = Integer.parseInt(input[i]);
            }

            int N = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < N; i++) {
                input = sc.nextLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);

                double r = Math.sqrt(x*x + y*y);
                if (r > radius[4]) continue;
                if (r < radius[0]) {
                    Answer += 50;
                    continue;
                }

                int multiple = 1;
                if (radius[1] < r && r < radius[2]) multiple = 3;
                if (radius[3] < r && r < radius[4]) multiple = 2;

                double radian = Math.atan2(y, x);
                radian *= (180 / Math.PI); // 각도로 변환
                if (radian < 0) radian += 360; // 180~360으로 변환
                radian -= 9;
                radian = (radian + 360) % 360;
                int add = score[(int) (radian / 18)] * multiple;
                Answer += add;
            }

            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}