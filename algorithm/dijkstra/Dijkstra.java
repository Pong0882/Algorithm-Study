package algorithm.dijkstra;

public class Dijkstra {
    static class Node implements Comparable<Node> {

        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, this.cost);

        }

    }

    public static void main(String[] args) {

    }
}
