package codility;

import java.util.ArrayList;

public class test {
    public static void main (String[] args) {
        System.out.println(solution(2, 4,2 ,4));
    }

    public static int solution(int A, int B, int C, int D) {
        // write your code in Java SE 8
        boolean[] visited = new boolean[4];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(A);
        list.add(B);
        list.add(C);
        list.add(D);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            visited[i] = true;
            for (int j = 0; j < 4; j++) {
                if (i == j) continue;
                visited[j] = true;
                int sumA = (list.get(i) - list.get(j)) * (list.get(i) - list.get(j));
                int sumB = 0;
                boolean isFirst = true;
                for (int k = 0; k < 4; k++) {
                    if (!visited[k]) {
                        if (isFirst) {
                            isFirst = false;
                            sumB += list.get(k);
                        } else {
                            sumB -= list.get(k);
                        }
                    }
                }

                sumB *= sumB;
                max = Math.max(max, sumA + sumB);
                visited[j] = false;

            }
            visited[i] = false;
        }
        return max;
    }
}
