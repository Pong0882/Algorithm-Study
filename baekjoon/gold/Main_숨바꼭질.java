package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_숨바꼭질 {
    static int N, K;
    static int[] paper;
    static int[] dr = { -1, 1 };

    static class Point implements Comparable<Point> {
        int p;
        int t;

        public Point(int p, int t) {
            this.p = p;
            this.t = t;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(t, o.t);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        paper = new int[100001];

        if (N > K) {
            System.out.println(N - K);
            return;
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(N, 1));
        Arrays.fill(paper, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            Point point = pq.poll();
            int here = point.p;
            int time = point.t;
            // System.out.println(here + " " + time);
            if (here == K) {
                System.out.println(time - 1);
                // System.out.println(cnt);
                // for (int i = 0; i < K; i++) {
                // System.out.print(paper[i] + " ");
                // }
                return;
            }
            for (int i = 0; i < 2; i++) {
                int next = here + dr[i];
                if (!check(next)) {
                    continue;
                }
                if (paper[next] <= time) {
                    continue;
                }
                paper[next] = time + 1;
                pq.add(new Point(next, time + 1));
            }
            int tmp = here;
            while (tmp * 2 < 100001) {
                tmp *= 2;
                if (paper[tmp] <= time) {
                    continue;
                }
                paper[tmp] = time;
                pq.add(new Point(tmp, time));
            }
        }
    }

    private static boolean check(int a) {
        return a >= 0 && a < 100001;
        
    }
}
