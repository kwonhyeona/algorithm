package codility;

public class CyclicRotation {
    public int[] solution (int[] A, int K) {
        int length = A.length;
        if (length == 0) return A;
        K = (K % length);

        int[] B = new int[length];

        for (int i = 0; i < length; i++) {
            int index = (i + K) % length;
            B[index] = A[i];
        }

        return B;
    }
}
