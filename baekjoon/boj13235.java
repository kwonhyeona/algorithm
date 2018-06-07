package baekjoon;


import java.util.Scanner;

public class boj13235 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int length = input.length();
        boolean isPalindrome = true;

        if (length == 1) System.out.println(true);
        else {
            for (int i = 0; i < length/ 2; i++) {
                if (input.charAt(i) != input.charAt(length - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }
            System.out.println(isPalindrome);
        }
    }
}
