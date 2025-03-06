package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    int u, v;
    double w;

    public Edge(int u, int v, double w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.w, o.w);
    }
}

public class Main_별자리만들기_Kru {
    static int n;
    static double[][] data;
    static List<Edge> edges = new ArrayList<>();
    static int[] parent;
    static int[] rank;
    static double result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        data = new double[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Double.parseDouble(st.nextToken());
            data[i][1] = Double.parseDouble(st.nextToken());
        }

        // 모든 간선 추가 (양방향)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double w = Math.sqrt(
                        Math.pow(data[i][0] - data[j][0], 2) + Math.pow(data[i][1] - data[j][1], 2));
                edges.add(new Edge(i, j, w));
            }
        }

        // 크루스칼 실행
        Kruskal();
        System.out.printf("%.2f\n", result);
    }

    // 크루스칼 알고리즘 실행
    private static void Kruskal() {
        Collections.sort(edges); // 간선을 가중치 기준으로 정렬

        // 유니온-파인드 초기화
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int cnt = 0;
        for (Edge edge : edges) {
            if (find(edge.u) != find(edge.v)) { // 사이클 방지
                union(edge.u, edge.v);
                result += edge.w;
                cnt++;
                if (cnt == n - 1)
                    break; // MST 완성 시 종료
            }
        }
    }

    // 유니온-파인드: 경로 압축 적용 (Find)
    private static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]); // 경로 압축 최적화
    }

    // 유니온-파인드: 유니온-바이-랭크 적용 (Union)
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (rank[a] > rank[b])
                parent[b] = a;
            else if (rank[a] < rank[b])
                parent[a] = b;
            else {
                parent[b] = a;
                rank[a]++;
            }
        }
    }
}
