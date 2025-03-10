package algorithm.MST;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class PrimGPT {
    // 간선 클래스: 도착 노드와 가중치 정보를 저장합니다.
    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // 인접 리스트로 그래프 표현
    static List<List<Edge>> graph = new ArrayList<>();

    // 프림 알고리즘을 이용해 최소 신장 트리(MST) 비용 계산
    public static int primMST(int start, int n) {
        boolean[] visited = new boolean[n]; // 방문한 정점을 체크하는 배열
        // 우선순위 큐를 사용하여 가중치가 가장 낮은 간선 우선 선택
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        int mstCost = 0;

        // 시작 정점을 방문 처리하고, 해당 정점의 모든 인접 간선을 큐에 추가
        visited[start] = true;
        pq.addAll(graph.get(start));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            // [프림 알고리즘] 방문한 정점이면 스킵 (이미 트리에 포함됨)
            if (visited[edge.to])
                continue;

            // 선택한 간선을 MST에 포함시키고, 총 비용 갱신
            visited[edge.to] = true;
            mstCost += edge.weight;

            // 새로 방문한 정점의 인접 간선을 큐에 추가 (아직 방문하지 않은 정점 대상으로)
            for (Edge next : graph.get(edge.to)) {
                if (!visited[next.to]) {
                    pq.offer(next);
                }
            }
        }
        return mstCost;
    }

    public static void main(String[] args) {
        int n = 5; // 정점 수
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // 무방향 그래프: 양쪽 모두에 간선 추가
        addEdge(0, 1, 2);
        addEdge(0, 3, 6);
        addEdge(1, 2, 3);
        addEdge(1, 3, 8);
        addEdge(1, 4, 5);
        addEdge(2, 4, 7);
        addEdge(3, 4, 9);

        int totalCost = primMST(0, n);
        System.out.println("Prim MST 총 비용: " + totalCost);
    }

    // 무방향 그래프의 간선을 추가하는 메소드
    private static void addEdge(int from, int to, int weight) {
        graph.get(from).add(new Edge(to, weight));
        graph.get(to).add(new Edge(from, weight));
    }
}
