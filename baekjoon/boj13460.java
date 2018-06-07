package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj13460 {
    static int[][] map; // #: 1, 나머지: 0
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static boolean[][] bVisited, rVisited;
    static BeadPosition beadPosition = new BeadPosition();
    static int holeX, holeY, N, M;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        bVisited = new boolean[N][M];
        rVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                String in = st.nextToken();
                switch (in) {
                    case "R": beadPosition.setRedX(i); beadPosition.setRedY(j); break;
                    case "B": beadPosition.setBlueX(i); beadPosition.setBlueY(j); break;
                    case "0": holeX = i; holeY = j; break;
                    case "#":  map[i][j] = 1; break;
                }
            }
            bfs();
        }
    }

    public static void bfs () {
        Queue<BeadPosition> q = new LinkedList<>();
        q.add(beadPosition);

        int count = 0;
        while (!q.isEmpty()) {
            if (count > 10) {
                System.out.println(-1);
                return;
            }
            int length = q.size();
            for (int i = 0; i < length; i++) {
                BeadPosition bp = q.poll();
                for (int j = 0; j < 4; j++) {
                    int rx = bp.getRedX() + dx[j];
                    int ry = bp.getRedY() + dy[j];
                    int bx = bp.getBlueX() + dx[j];
                    int by = bp.getBlueY() + dy[j];

//                    while ()

                    if (bx == holeX && by == holeY) continue;
                    if (rx == holeX && ry == holeY) {
                        System.out.println(count);
                        return;
                    }
                    if (rx >= 0 && ry >= 0 && rx < N && ry < M) {
                        rx = (rx == 0 ? 1 : (rx == N - 1 ? N - 2 : rx));
                        ry = (ry == 0 ? 1 : (ry == N - 1 ? N - 2 : ry));
                        bx = (bx == 0 ? 1 : (bx == N - 1 ? N - 2 : bx));
                        by = (by == 0 ? 1 : (by == N - 1 ? N - 2 : by));
                        q.add(new BeadPosition(rx, ry, bx, by));
                    }
                }
            }
            count++;
        }
    }
}

class BeadPosition {
    int redX, redY;
    int blueX, blueY;

    public BeadPosition() {
    }

    public BeadPosition(int redX, int redY, int blueX, int blueY) {
        this.redX = redX;
        this.redY = redY;
        this.blueX = blueX;
        this.blueY = blueY;
    }

    public int getRedX() {
        return redX;
    }

    public void setRedX(int redX) {
        this.redX = redX;
    }

    public int getRedY() {
        return redY;
    }

    public void setRedY(int redY) {
        this.redY = redY;
    }

    public int getBlueX() {
        return blueX;
    }

    public void setBlueX(int blueX) {
        this.blueX = blueX;
    }

    public int getBlueY() {
        return blueY;
    }

    public void setBlueY(int blueY) {
        this.blueY = blueY;
    }
}