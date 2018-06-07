package samsungSW;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q1949 {
    static int N, K, maxHeight, finalLength;
    static int mount[][], visit[][];
    static ArrayList<Node> maxHeightIndex;
    static int[] dx = { 0, -1, 0, 1 }, dy = { 1, 0, -1, 0 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        final int TESTCASE_COUNT = Integer.parseInt(br.readLine());
        for (int i = 0; i < TESTCASE_COUNT; i++) {
            String input[] = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            K = Integer.parseInt(input[1]);
            maxHeightIndex = new ArrayList<>();
            mount = new int[N][N];

            maxHeight = 0;
            finalLength = 0;

            // 입력받기
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    mount[j][k] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, mount[j][k]);
                }
            }

            // 최대높이 지점을 저장
            addMaxHeightNode();

            // maxHeightIndex 리스트를 돌며 그 자리에서의 최대 높이를 구한다.
            for (int j = 0; j < maxHeightIndex.size(); j++) {
                visit = new int[N][N];
                Node node = maxHeightIndex.get(j);
                visit[node.x][node.y] = 1;

                finalLength = Math.max(dfs(node.x, node.y, maxHeight, false), finalLength);
            }

            bw.write("#" + (i + 1) + " " + finalLength + "\n");
        }
        bw.flush();
    }

    private static void addMaxHeightNode () {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (mount[i][j] == maxHeight) maxHeightIndex.add(new Node(i, j));
            }
        }
    }

    private static int dfs (int x, int y, int previousHeight, boolean isDone) {
        //
        int maxLength = 0;
        for (int i = 0; i < 4; i++) {
            int sx = x + dx[i], sy = y + dy[i];
            if (sx >= 0 && sx < N && sy >= 0 && sy < N && visit[sx][sy] == 0) {
                if (mount[sx][sy] < previousHeight) {
                    visit[sx][sy] = 1;
                    maxLength = Math.max(maxLength, dfs(sx, sy, mount[sx][sy], isDone));
                } else if (!isDone && (mount[sx][sy] - previousHeight + 1) <= K) {
                    visit[sx][sy] = 1;
                    maxLength = Math.max(maxLength, dfs(sx, sy, previousHeight - 1, true));
                }
                visit[sx][sy] = 0;
            }

        }

        return maxLength + 1;
    }
}

class Node {
    int x, y;

    Node (int x, int y) {
        this.x = x;
        this.y = y;
    }
}