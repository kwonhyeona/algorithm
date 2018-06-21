package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2864 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        int aLength = a.length(), bLength = b.length();
        for (int i = 0; i < aLength; i++) {
            if (a.charAt(i) == '6') a = a.substring(0, i) + "5" + a.substring(i + 1);
        }

        for (int i = 0; i < bLength; i++) {
            if (b.charAt(i) == '6') b = b.substring(0, i) + "5" + b.substring(i + 1);
        }

        System.out.print((Integer.parseInt(a)) + (Integer.parseInt(b)));

        for (int i = 0; i < aLength; i++) {
            if (a.charAt(i) == '5') a = a.substring(0, i) + "6" + a.substring(i + 1);
        }

        for (int i = 0; i < bLength; i++) {
            if (b.charAt(i) == '5') b = b.substring(0, i) + "6" + b.substring(i + 1);
        }
        System.out.print(" " + ((Integer.parseInt(a)) + (Integer.parseInt(b))));
    }
}
