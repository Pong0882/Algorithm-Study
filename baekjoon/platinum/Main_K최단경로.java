package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_K최단경로 {
    static int N, M, K;

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

    static int[] result;
    static int[] count;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static ArrayDeque<Edge>[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayDeque[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayDeque<>();
        }
        //////////////
        ///
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new Edge(e, w));
        }

        count = new int[N + 1];
        result = new int[N + 1];
        Arrays.fill(result, -1);

        pq.add(new Edge(1, 0));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (++count[cur.e] == K) {
                result[cur.e] = cur.w;
            }
            if (count[cur.e] > K) {
                continue;
            }

            for (Edge next : list[cur.e]) {
                int nextValue = cur.w + next.w;
                pq.add(new Edge(next.e, nextValue));
            }
        }
        for (int i = 1; i < N + 1; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
}
