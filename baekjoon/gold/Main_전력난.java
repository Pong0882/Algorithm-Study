package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_전력난 {
    static int m, n;

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
    static int result;
    static int[] boss;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points = new PriorityQueue<>();
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) {
                break;
            }
            boss = new int[m];
            result = 0;
            max = 0;
            for (int i = 0; i < m; i++) {
                boss[i] = i;
            }
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                points.add(new Edge(s, e, w));
                max += w;
                // points.add(new Edge(e, s, w));
            }

            int cnt = 0;
            while (cnt != m - 1) {
                Edge tmp = points.poll();
                if (Union(tmp.e, tmp.s)) {
                    cnt++;
                    result += tmp.w;
                }
            }
            System.out.println(max - result);
        }
    }

    private static boolean Union(int e, int s) {
        int A = bossfind(e);
        int B = bossfind(s);

        if (A == B) {
            return false;
        }
        boss[A] = B;
        return true;
    }

    private static int bossfind(int e) {
        if (e == boss[e]) {
            return e;
        }
        return boss[e] = bossfind(boss[e]);
    }
}
