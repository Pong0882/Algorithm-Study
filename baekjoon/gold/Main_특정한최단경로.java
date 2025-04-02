package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_특정한최단경로 {
    static int one, two;

    private static class Edge implements Comparable<Edge> {
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

    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int[] dp1;
    static int[] dp2;
    static ArrayList<Edge>[] list;
    static int N, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        dp1 = new int[N + 1];
        dp2 = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new Edge(e, w));
            list[e].add(new Edge(s, w));
        }
        st = new StringTokenizer(br.readLine());
        one = Integer.parseInt(st.nextToken());
        two = Integer.parseInt(st.nextToken());

        Arrays.fill(dp1, Integer.MAX_VALUE);
        Arrays.fill(dp2, Integer.MAX_VALUE);

        dp1[one] = 0;
        pq.add(new Edge(one, 0));
        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int e = tmp.e;
            int w = tmp.w;
            if (dp1[e] < w) {
                continue;
            }

            for (Edge next : list[e]) {
                int newCost = dp1[e] + next.w;
                if (dp1[next.e] <= newCost) {
                    continue;
                }
                dp1[next.e] = newCost;
                pq.add(next);
            }
        }
        dp2[two] = 0;
        pq.add(new Edge(two, 0));
        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int e = tmp.e;
            int w = tmp.w;
            if (dp2[e] < w) {
                continue;
            }

            for (Edge next : list[e]) {
                int newCost = dp2[e] + next.w;
                if (dp2[next.e] <= newCost) {
                    continue;
                }
                dp2[next.e] = newCost;
                pq.add(next);
            }
        }
        // System.out.println(Arrays.toString(dp1));
        // System.out.println(Arrays.toString(dp2));
        boolean can1 = check(dp1[1], dp1[two], dp2[N]);
        int result1;
        if (can1) {
            result1 = dp1[1] + dp1[two] + dp2[N];
        } else {
            result1 = Integer.MAX_VALUE;
        }
        boolean can2 = check(dp2[1], dp2[one], dp1[N]);
        int result2;
        if (can2) {
            result2 = dp2[1] + dp2[one] + dp1[N];
        } else {
            result2 = Integer.MAX_VALUE;
        }
        int result = Math.min(result1, result2);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static boolean check(int c, int b, int a) {
        if (a == Integer.MAX_VALUE || b == Integer.MAX_VALUE || c == Integer.MAX_VALUE) {
            return false;
        }
        return true;
    }
}