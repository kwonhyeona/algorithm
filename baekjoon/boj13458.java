package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj13458 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] person = new int[N];
        long count = N;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int totalSupervision = Integer.parseInt(st.nextToken());
        int subSupervision = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            if (person[i] - totalSupervision > 0)
                count += Math.ceil(1.0 * (person[i] - totalSupervision) / subSupervision);
        }

        System.out.println(count);
    }
}
