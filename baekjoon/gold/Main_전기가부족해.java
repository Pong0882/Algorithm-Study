package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_전기가부족해 {
    static int n, m, k;

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

    static int[] boss;
    static int result;
    static PriorityQueue<Edge> points = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        boss = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            points.add(new Edge(s, e, w));
        }

        for (int i = 0; i < n + 1; i++) {
            boss[i] = i;
        }

        int cnt = 0;
        while (!points.isEmpty()) {
            if (cnt == n - 1) {
                break;
            }
            Edge tmp = points.poll();
            if (Union(tmp.e, tmp.s)) {
                result += tmp.w;
                cnt++;
            }
        }
        System.out.println(result);
    }

    private static boolean Union(int e, int s) {
        int a = bf(e);
        int b = bf(s);
        if (a == b) {
            return false;
        }
        boss[a] = b;
        return true;
    }

    private static int bf(int e) {
        if (boss[e] == e) {
            return e;
        }
        return boss[e] = bf(boss[e]);
    }
}
