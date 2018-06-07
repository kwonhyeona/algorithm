package codility;

public class BinaryGap {
    public static void main (String[] args) {
        int N = 16;
        String binary = Integer.toBinaryString(N);
        String[] n2 = binary.split("1");
        int max = 0;

        int length = (binary.lastIndexOf("1") == binary.length() - 1) ? n2.length : n2.length - 1;
        for (int i = 0; i < length; i++) {
            max = Math.max(max, n2[i].length());
        }

        System.out.println(max);
    }
}
