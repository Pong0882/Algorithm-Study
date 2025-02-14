package algorithm.dijkstra;

import java.util.*;

public class Dijkstra {
    static class Node implements Comparable<Node> {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost); // 비용이 작은 것이 우선순위 높음
        }
    }

    public static void dijkstra(int[][] grid) {
        int N = grid.length;
        int[][] dist = new int[N][N];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = grid[0][0];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, grid[0][0]));

        int[] dx = { 0, 0, -1, 1 }; // 상하좌우 이동
        int[] dy = { -1, 1, 0, 0 };

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int x = now.x, y = now.y, cost = now.cost;

            if (dist[x][y] < cost)
                continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    int newCost = cost + grid[nx][ny];
                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.offer(new Node(nx, ny, newCost));
                    }
                }
            }

            // 현재 dist 배열 출력 (과정 확인용)
            printDist(dist);
        }

        System.out.println("최소 비용: " + dist[N - 1][N - 1]);
    }

    private static void printDist(int[][] dist) {
        System.out.println("현재 dist 배열 상태:");
        for (int[] row : dist) {
            for (int value : row) {
                System.out.print((value == Integer.MAX_VALUE ? "INF" : value) + "\t");
            }
            System.out.println();
        }
        System.out.println("--------------------------");
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
}
