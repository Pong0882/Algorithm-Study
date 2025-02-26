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
        // TODO Auto-generated method stub
        return this.w - o.w;
    }

}

public class Main_네트워크연결 {
    static int N;
    static int L;
    static int[] boss;
    static int min;

    static PriorityQueue<Edge> points;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        L = Integer.parseInt(br.readLine());
        points = new PriorityQueue<>();
        boss = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            boss[i] = i;
        }
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            points.offer(new Edge(s, e, w));
        }
        int cnt = 0;
        while (cnt < N - 1) {
            Edge edge = points.poll();
            if (union(edge.s, edge.e)) {
                cnt++;
                min += edge.w;
            }
        }
        System.out.println(min);
    }

    private static boolean union(int s, int e) {
        int A = findBoss(s);
        int B = findBoss(e);
        if (A == B) {
            return false;
        }
        boss[A] = B;
        return true;
    }

    private static int findBoss(int s) {
        if (s == boss[s])
            return s;
        return boss[s] = findBoss(boss[s]);
    }
}
