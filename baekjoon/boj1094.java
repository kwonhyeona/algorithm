package baekjoon;

import java.util.Scanner;

public class boj1094 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int length = 64;
        int count = 0;

        while (x > 0) {
            if (length > x) {
                length /= 2;
            } else {
                count++;
                x -= length;
            }
        }
        System.out.println(count);
    }
}
