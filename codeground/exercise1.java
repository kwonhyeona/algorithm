package codeground;


import java.util.Scanner;

// 홀수 번 나타나는 숫자만 XOR한 결과를 나타내라
// Solution : 같은 숫자를 XOR 하면 어차피 0이 된다.
//            따라서 홀수, 짝수인지를 구별하지말고 모두 XOR하면 짝수이면 알아서 0이 된다.
public class exercise1 {
    static int Answer;

    public static void main(String args[])	{
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for(int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(sc.nextLine());
            String in[] = sc.nextLine().split(" ");

            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(in[j]);
                Answer = Answer^input;
            }

            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}
