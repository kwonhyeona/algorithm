package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1977 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int end = Integer.parseInt(st.nextToken());

        for (int i = start; i <= end; i++) {
            double num = Math.sqrt(i);
            if (num == (int) num) {
                int max = (int) num + 1;
                int sum = i;
                while (max * max <= end) {
                    sum += max * max;
                    max = max + 1;
                }

                System.out.println(sum);
                System.out.print(i);
                br.close();
                return;
            }
        }
        System.out.print(-1);
    }
}
