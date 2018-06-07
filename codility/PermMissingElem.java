package codility;

public class PermMissingElem {
    public static void main (String[] args) {
        int[] A = new int[100000];


        for (int i = 0; i < A.length; i++) {
            A[i] = i + 2;
        }

        System.out.println(A[A.length - 1]);
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        long length = A.length + 1;
        System.out.println(length);
        long total = (length * (length + 1)) / 2;
        System.out.println(total);

        for (int num : A) {
            total -= num;
        }

        return (int)total;
    }
}
