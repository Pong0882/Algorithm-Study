package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_최소비용구하기 {
    static int N, M;
    static int result;
    static int start, end;

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

    static int[] dp;
    static PriorityQueue<Edge> points = new PriorityQueue<>();

    static ArrayList<Edge>[] lists;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        lists = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            lists[s].add(new Edge(e, w));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        points.add(new Edge(start, 0));
        dp[start] = 0;
        while (!points.isEmpty()) {
            Edge cur = points.poll();
            if (cur.e == end) {
                break;
            }
            if (dp[cur.e] < cur.w) {
                continue;
            }
            for (Edge next : lists[cur.e]) {
                int nw = dp[cur.e] + next.w;
                if (dp[next.e] <= nw) {
                    continue;
                }
                dp[next.e] = nw;
                points.add(new Edge(next.e, nw));
            }
        }
        // System.out.println(Arrays.toString(dp));
        System.out.println(dp[end]);
    }
}
