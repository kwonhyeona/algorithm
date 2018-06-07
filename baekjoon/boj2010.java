package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2010 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int sum = 0;
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            sum += Integer.parseInt(st.nextToken());
        }

        System.out.println(sum - count + 1);
        br.close();
    }
}
