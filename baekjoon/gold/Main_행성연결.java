package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_행성연결 {
    static int N;

    static class Edge implements Comparable<Edge> {

        int s, e, w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(w, o.w);
        }

    }

    static PriorityQueue<Edge> points;
    static int[] boss;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        points = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (i == j) {
                    continue;
                }
                points.add(new Edge(i, j, tmp));
            }
        }
        boss = new int[N];
        for (int i = 0; i < N; i++) {
            boss[i] = i;
        }

        int cnt = 0;
        long result = 0;
        while (cnt != N - 1) {
            Edge tmp = points.poll();
            if (union(tmp.s, tmp.e)) {
                result += tmp.w;
                cnt++;
            }
        }
        System.out.println(result);
    }

    private static boolean union(int s, int e) {
        int bossA = bossFind(s);
        int bossB = bossFind(e);
        if (bossA == bossB) {
            return false;
        }
        boss[bossA] = bossB;
        return true;
    }

    private static int bossFind(int s) {
        if (s == boss[s])
            return s;
        return boss[s] = bossFind(boss[s]);
    }
}
