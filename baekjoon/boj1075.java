package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1075 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int mod = (N / 100) % F;

        int answer = mod * 100 - 1;
        for (int i = 0; i < 100; i++) {
            answer++;
            if (answer % F == 0) {
                mod = answer % 100;
                System.out.println(mod < 10 ? "0" + mod : mod);
                br.close();
                break;
            }
        }
    }
}
