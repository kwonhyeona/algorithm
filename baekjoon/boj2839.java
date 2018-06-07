package baekjoon;

import java.util.Scanner;

public class boj2839 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count5 = N / 5;
        do {
            if ((N - count5 * 5) % 3 == 0) {
                System.out.print(count5 + (N - count5 * 5) / 3);
                return;
            }
        } while (--count5 >= 0);
        System.out.print(-1);
    }
}
