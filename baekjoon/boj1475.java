package baekjoon;

import java.util.Scanner;

public class boj1475 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] numberCount = new int[9];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < input.length(); i++) {
            int index;
            switch (input.charAt(i)) {
                case '9':
                case '6':
                    numberCount[6]++;
                    max = Math.max(max, (int) Math.ceil(( 1.0 * numberCount[6]) / 2));
                    break;
                default:
                    index = input.charAt(i) - '0';
                    numberCount[index]++;
                    max = Math.max(max, numberCount[index]);
                    break;
            }
        }
        System.out.print(max);
    }
}
