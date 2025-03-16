package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_임계경로 {
    static int resultTime, resultload;

    static class Edge {
        int e, t;

        public Edge(int e, int t) {
            this.e = e;
            this.t = t;
        }
    }

    static int n, m;
    static ArrayList<Edge>[] list;
    static ArrayList<Edge>[] revList;
    static boolean[] visited;
    static int[] indeg;
    static int start, end;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        revList = new ArrayList[n + 1];
        indeg = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
            revList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            indeg[e]++;
            list[s].add(new Edge(e, t));
            revList[e].add(new Edge(s, t));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        dp = new int[n + 1];
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Edge edge : list[cur]) {
                if (dp[edge.e] < dp[cur] + edge.t) {
                    dp[edge.e] = dp[cur] + edge.t;
                }
                if (--indeg[edge.e] == 0) {
                    q.add(edge.e);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        System.out.println(dp[end]);
        visited = new boolean[n + 1];
        q.add(end);
        visited[end] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Edge edge : revList[cur]) {
                if (dp[edge.e] == dp[cur] - edge.t) {
                    resultload++;
                    if (!visited[edge.e]) {
                        visited[edge.e] = true;
                        q.add(edge.e);
                    }
                }
            }
        }
        System.out.println(resultload);
    }
}
