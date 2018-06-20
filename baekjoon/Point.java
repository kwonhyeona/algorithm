package baekjoon;

public class Point {
    int x;     // x좌표
    int y;     // y좌표
    int count; // 몇번 말처럼 움직였는지

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}