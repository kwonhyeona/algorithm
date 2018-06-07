package baekjoon;

import java.util.Scanner;

public class boj1193 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int n = 1;
        int i;

        while (true) {
            i = (n * (n + 1) / 2) - X;
            if (0 <= i) { break; }
            else { n++; }
        }

        if (n % 2 == 0) { System.out.print((n - i) + "/" + (1 + i)); }
        else { System.out.print((1 + i) + "/" + (n - i)); }
    }
}
