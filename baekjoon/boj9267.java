package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj9267 {
    static long a, b, S;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.valueOf(st.nextToken());
        b = Long.valueOf(st.nextToken());
        S = Long.valueOf(st.nextToken());

        System.out.println(minus(S) ? "YES" : "NO");
    }

    private static boolean minus (long s) {
        // a 뺄 경우
        long aMinus = s - a;
        long bMinus = s - b;

        boolean isPossible = false;

        if (aMinus == 0 || bMinus == 0) {
            isPossible = true;
        }

        // a 뺄 경우
        if (!isPossible) {
            isPossible = ( (aMinus > 0) && minus(aMinus) );
        }

        if (!isPossible) {
            isPossible = ( (bMinus > 0) && minus(bMinus) );
        }

        return isPossible;
    }
}
