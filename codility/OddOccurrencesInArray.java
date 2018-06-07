package codility;

public class OddOccurrencesInArray {
    public static void main (String[] args) {
        int[] A = {9,3,9,3,9,7,9};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int number  = 0;
        for (int a : A) { number = number ^ a; }

        return number;
    }
}
