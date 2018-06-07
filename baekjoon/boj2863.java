package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj2863 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        LinkedList<Double> list = new LinkedList<>();
        double num1 = Integer.parseInt(st.nextToken());
        double num2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        double num4 = Integer.parseInt(st.nextToken());
        double num3 = Integer.parseInt(st.nextToken());
        list.add(num1);
        list.add(num2);
        list.add(num3);
        list.add(num4);

        double max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < 4; i++) {
            double result = (list.get(0) / list.get(3)) + (list.get(1) / list.get(2));
            if (max < result) {
                count = i;
                max = result;
            }
            list.add(0, list.pollLast());
        }

        System.out.print(count);
        br.close();
    }
}
