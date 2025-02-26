package algorithm.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int s, e, w;

    public Edge(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}

public class Kruskal {
    static PriorityQueue<Edge> points;
    static int[] boss;
    static int N, L;
    static long min = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        points = new PriorityQueue<>();

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            points.offer(new Edge(s, e, w));
        }

        boss = new int[N + 1];
        for (int i = 0; i <= N; i++) { // 부모 초기화
            boss[i] = i;
        }
        int cnt = 0;
        while (cnt != N - 1) {
            Edge edge = points.poll();
            if (union(edge.s, edge.e)) {
                cnt++;
                min += edge.w;
            }
        }
        System.out.println(min);
    }

    private static boolean union(int s, int e) {
        int bossA = findBoss(s);
        int bossB = findBoss(e);

        if (bossA == bossB) {
            return false;
        }
        boss[bossA] = bossB;
        return true;
    }

    private static int findBoss(int x) {
        if (x == boss[x]) {
            return x;
        }
        return boss[x] = findBoss(boss[x]);
    }
}
