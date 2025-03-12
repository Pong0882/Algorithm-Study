package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_최단경로 {
    static int V, E;
    static int start;

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

    static ArrayList<Edge>[] list;

    static PriorityQueue<Edge> points = new PriorityQueue<>();
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        dp = new int[V + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        list = new ArrayList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new Edge(e, w));
        }

        points.add(new Edge(start, 0));
        dp[start] = 0;
        while (!points.isEmpty()) {
            Edge tmp = points.poll();

            if (dp[tmp.e] < tmp.w) {
                continue;
            }
            for (Edge next : list[tmp.e]) {
                int newCost = dp[tmp.e] + next.w;
                if (dp[next.e] < newCost) {
                    continue;
                }
                dp[next.e] = newCost;
                points.add(new Edge(next.e, newCost));
            }
        }
        for (int i = 1; i < V + 1; i++) {
            sb.append(dp[i] == Integer.MAX_VALUE ? "INF" : dp[i]).append("\n");
        }
        System.out.println(sb);
    }
}
