package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2965 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int kangaroo1 = Integer.parseInt(st.nextToken());
        int kangaroo2 = Integer.parseInt(st.nextToken());
        int kangaroo3 = Integer.parseInt(st.nextToken());

        int count = 0;
        int minus1 = Math.abs(kangaroo1 - kangaroo2);
        int minus2 = Math.abs(kangaroo2 - kangaroo3);

        while (!(minus1 == 1 && minus2 == 1)) {
            count++;
            if (minus1 > minus2) {
                kangaroo3 = kangaroo2;
                kangaroo2 = kangaroo1 + 1;
            } else {
                kangaroo1 = kangaroo2;
                kangaroo2 = kangaroo3 - 1;
            }
            minus1 = Math.abs(kangaroo1 - kangaroo2);
            minus2 = Math.abs(kangaroo2 - kangaroo3);
        }
        System.out.print(count);
    }
}
