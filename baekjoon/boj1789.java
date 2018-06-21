package baekjoon;

import java.util.Scanner;

public class boj1789 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();
        if (S == 1 || S == 2) {
            System.out.print(1);
            return;
        }
        long count = 0;
        while ((count * (count + 1) / 2) < S) {
            count++;
        }

        if ((count * (count + 1) / 2) == S) System.out.print(count);
        else System.out.print(count - 1);
    }
}
