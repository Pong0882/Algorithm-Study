package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_행성연결Prim {
    static class Edge implements Comparable<Edge> {
        int e, w;

        public Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(w, o.w);
        }

    }

    static PriorityQueue<Edge> Points;
    static ArrayList<Edge>[] adj;
    static long result;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (i == j) {
                    continue;
                }
                adj[i].add(new Edge(j, tmp));
                // System.out.println(j + " " + tmp);
            }
        }

        Points = new PriorityQueue<>();
        Points.add(new Edge(0, 0));
        visited = new boolean[N];
        int cnt = 0;
        while (!Points.isEmpty()) {
            if (cnt == N - 1) {
                break;
            }
            Edge cur = Points.poll();
            if (visited[cur.e]) {
                continue;
            }
            visited[cur.e] = true;

            result += cur.w;
            // System.out.println(result);
            for (Edge tmp : adj[cur.e]) {
                if (visited[tmp.e]) {
                    continue;
                }
                Points.add(tmp);
            }
        }
        System.out.println(result);
    }
}
