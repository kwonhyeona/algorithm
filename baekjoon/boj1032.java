package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1032 {
    static String[] strArr;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        strArr = new String[N];

        for (int i = 0; i < N; i++) {
            strArr[i] = br.readLine();
        }

        int length = strArr[0].length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (isCharSame(i)) { sb.append(strArr[0].charAt(i)); }
            else { sb.append("?"); }
        }
        System.out.print(sb);
        br.close();
    }

    private static boolean isCharSame (int index) {
        for (int i = 0; i < strArr.length - 1; i++) {
            if (strArr[i].charAt(index) != strArr[i + 1].charAt(index)) return false;
        }
        return true;
    }
}