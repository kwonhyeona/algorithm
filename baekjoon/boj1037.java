package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1037 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < count; i++) {
            int input = Integer.parseInt(st.nextToken());
            max = Math.max(max, input);
            min = Math.min(min, input);
        }

        System.out.println(max * min);
        br.close();
    }
}
