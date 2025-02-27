package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    public Edge(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

    int s, e, w;

    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }

}

public class Main_도시분할계획 {
    static PriorityQueue<Edge> points;
    static int N, L;
    static int min;

    static int expensive;
    static int[] boss;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        boss = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            boss[i] = i;
        }
        points = new PriorityQueue<>();

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            points.offer(new Edge(s, e, w));
        }

        int cnt = 0;
        while (cnt != N - 1) {
            Edge edge = points.poll();
            if (Union(edge.s, edge.e)) {
                cnt++;
                min += edge.w;
                expensive = Math.max(expensive, edge.w);
            }
        }
        System.out.println(min - expensive);
    }

    private static boolean Union(int s, int e) {
        int A = findBoss(s);
        int B = findBoss(e);

        if (A == B) {
            return false;
        }
        boss[A] = B;
        return true;
    }

    private static int findBoss(int x) {
        if (x == boss[x]) {
            return x;
        }
        return boss[x] = findBoss(boss[x]);
    }
}
