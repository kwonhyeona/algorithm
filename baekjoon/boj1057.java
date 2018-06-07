package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1057 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int jimin = Integer.parseInt(st.nextToken());
        int hansoo = Integer.parseInt(st.nextToken());

        int count = 0;
        while (jimin != hansoo) {
            jimin = jimin / 2 + jimin % 2;
            hansoo = hansoo / 2 + hansoo % 2;
            count++;
        }
        System.out.println(count);
        br.close();
    }
}
