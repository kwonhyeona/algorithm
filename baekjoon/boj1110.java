package baekjoon;

import java.util.Scanner;

public class boj1110 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int startNumber = sc.nextInt();
        int addNumber = startNumber;
        int count = 0;

        do {
            int num10 = addNumber / 10; // 10의 자리
            int num1 = addNumber % 10; // 1의 자리
            addNumber = num1 * 10 + (num1 + num10) % 10;
            count++;
        } while (startNumber != addNumber);

        System.out.print(count);
        sc.close();
    }
}
