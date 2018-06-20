package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj6087 {
    static int W, H, mirrorCount = 0;
    static String[][] map;
    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        W = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[0]);
        map = new String[W][H];
        visited = new int[W][H];

        ArrayList<Node1> dot = new ArrayList<>();
        for (int i = 0; i < W; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < H; j++) {
                map[i][j] = input[j];
                if (map[i][j].equals("C")) dot.add(new Node1(i, j, 0));
            }
        }

        visited[dot.get(0).x][dot.get(0).y] = 1;
        System.out.println(bfs(dot.get(0)));
    }

    private static int bfs (Node1 n) {
        Queue<Node1> queue = new LinkedList<>();
        queue.add(n);

        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                Node1 node = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int sx = node.x + dx[j], sy = node.y + dy[j];
                    if (sx >= 0 && sx < W && sy >= 0 && sy < H && visited[sx][sy] == 0) {
                        if (map[sx][sy].equals("C"))
                            return node.mirror;
                        if (map[sx][sy].equals(".")) {
                            visited[sx][sy] = 1;
                            int m = node.mirror;
                            if (node.previous != null && (node.x - node.previous.x) != (sx - node.x))
                                m++;
                            Node1 node2 = new Node1(sx, sy, node, m);
                            queue.add(node2);
                        }
                    }
                }
            }
        }
        return 0;
    }
}

class Node1 extends Node {
    Node1 previous;
    int mirror;

    public Node1(int x, int y, int mirror) {
        this.x = x;
        this.y = y;
        this.mirror = mirror;
    }

    public Node1(int x, int y, Node1 previous, int mirror) {
        this.x = x;
        this.y = y;
        this.previous = previous;
        this.mirror = mirror;
    }

    public void setPrevious(Node1 previous) {
        this.previous = previous;
    }

    public void setMirror(int mirror) {
        this.mirror = mirror;
    }
}