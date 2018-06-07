package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj1002 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            if (x1 == x2 && y1 == y2) { // 중심이 같을 때
                if (r1 == r2) bw.write(-1 + "\n");
                else bw.write(0 + "\n");
            } else { // 중심이 다를 때
                double sum = r1 + r2, sub = Math.abs(r1 - r2);
                double distance = Math.sqrt((x1 - x2)* (x1 - x2) + (y1 - y2)* (y1 - y2));
                if (sub < distance && distance < sum) bw.write(2 + "\n");
                else if (sum == distance || sub == distance) bw.write(1 + "\n");
                else bw.write(0 + "\n");
            }
        }
        bw.close();
        br.close();
    }
}
