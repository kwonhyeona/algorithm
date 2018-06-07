package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj1076 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long resistance = 0;
        String[] arr = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        List<String> list = Arrays.asList(arr);

        for (int i = 1; i >= 0; i--) {
            st = new StringTokenizer(br.readLine());
            int number = list.indexOf(st.nextToken());
            resistance += number * Math.pow(10, i);
        }
        st = new StringTokenizer(br.readLine());
        int number = list.indexOf(st.nextToken());
        resistance *= Math.pow(10, number);
        System.out.print(resistance);
        br.close();
    }
}
