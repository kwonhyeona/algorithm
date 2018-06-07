package codility;

public class TapeEqual {
    public static void main (String[] args) {
        int[] A = {3,1,2,4,3};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int length = A.length;
        long[] dp = new long[length];

        dp[0] = A[0];
        for (int i = 1; i < length; i++) {
            dp[i] = dp[i - 1] + A[i];
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < length - 1; i++) {
            min = Math.min(min, (int) Math.abs(dp[i] * 2 - dp[length - 1]));
        }

        return min;
    }
}
