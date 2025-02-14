package algorithm.dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstraPrac {
    static class Node implements Comparable<Node> {

        int x, y, value;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }

    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 3, 1, 9 },
                { 5, 2, 2, 8 },
                { 4, 1, 7, 3 },
                { 3, 6, 2, 1 }
        };

        dijkstra(grid);
    }

    private static void dijkstra(int[][] grid) {
        int N = grid.length;
        int[][] dijk = new int[N][N];
        for (int[] row : dijk) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dijk[0][0] = grid[0][0];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, grid[0][0]));

        int[] dx = { 0, 0, -1, 1 }; // 상하좌우 이동
        int[] dy = { -1, 1, 0, 0 };

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int x = now.x;
            int y = now.y;
            int value = now.value;

            if (dijk[x][y] < value) {
                continue;
            }
        }
    }

}
