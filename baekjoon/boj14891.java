package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj14891 {
    static int ROTATE_COUNT;
    static final int LEFT = -1, RIGHT = 1;
    static LinkedList<Integer> saw[] = new LinkedList[4];
    static Relation relations[] = new Relation[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 톱니바퀴 상태 입력받기
        for (int i = 0; i < 4; i++) {
            if (i != 3) relations[i] = new Relation(i, i + 1);

            String[] input = br.readLine().split("");
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < 8; j++) {
                list.add(Integer.parseInt(input[j]));
            }
            saw[i] = list;
        }

        ROTATE_COUNT = Integer.parseInt(br.readLine());

        for (int i = 0; i < ROTATE_COUNT; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            setRelations();
            rotate(index, direction);
            changeNeighbor(index + 1, (direction == -1) ? 1 : -1, RIGHT);
            changeNeighbor(index - 1, (direction == -1) ? 1 : -1, LEFT);
        }

        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (saw[i].get(0).equals(1))
                score += Math.pow(2, i);
        }

        System.out.println(score);
    }

    private static void rotate (int index, int direction) {
        switch (direction) {
            case -1: saw[index].add(saw[index].poll()); break;
            case 1:
                int a = saw[index].pollLast();
                saw[index].add(0, a);
                break;
        }
    }

    private static void setRelations () {
        for (int i = 0; i < 3; i ++) {
            relations[i].setSame(saw[i].get(2).equals(saw[i + 1].get(6)));
        }
    }

    private static void changeNeighbor (int index, int direction, int flag) {
        switch (flag) {
            case LEFT:
                if (index < 0) return;
                if (!relations[index].isSame()) rotate(index, direction);
                else return;
                break;
            case RIGHT:
                if (index > 3) return;
                if (!relations[index - 1].isSame()) rotate(index, direction);
                else return;
                break;
        }
        changeNeighbor(index + flag, (direction == 1) ? -1 : 1, flag);
    }
}

class Relation {
    int leftSaw;
    int rightSaw;
    boolean isSame;

    public Relation(int leftSaw, int rightSaw) {
        this.leftSaw = leftSaw;
        this.rightSaw = rightSaw;
    }

    public void setSame(boolean same) {
        isSame = same;
    }

    public boolean isSame() {
        return isSame;
    }
}
