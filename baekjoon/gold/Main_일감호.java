package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_일감호 {
    static int N, M;
    static long K;

    static class Edge implements Comparable<Edge> {
        int s, w;

        public Edge(int s, int w) {
            this.s = s;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compareUnsigned(w, o.w);
        }

    }

    static boolean[] gongsa;
    static int[] weight;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int[] boss;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        if (M <= 1) {
            System.out.println("YES");
            return;
        }
        weight = new int[N + 1];
        gongsa = new boolean[N + 1];
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            weight[i + 1] = Integer.parseInt(st.nextToken());
            pq.add(new Edge(i + 1, weight[i + 1]));
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int tmp = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());
            tmp2 = Math.min(tmp, tmp2);
            if (tmp == N) {
                tmp2 = tmp;
            }
            gongsa[tmp2] = true;
        }
        // System.out.println(Arrays.toString(gongsa));
        boss = new int[N + 1];
        int rank = 1;
        for (int i = 1; i <= N; i++) {
            boss[i] = rank;
            if (gongsa[i]) {
                rank++;
            }
        }
        if (rank == boss[N]) {
            for (int i = N; i > 0; i--) {
                if (gongsa[i]) {
                    break;
                }
                boss[i] = boss[1];
            }
        }
        // System.out.println(Arrays.toString(boss));
        visited = new boolean[rank];
        // System.out.println(rank);
        // System.out.println(Arrays.toString(visited));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int building = cur.s;
            int stone = cur.w;
            if (visited[boss[building]]) {
                continue;
            }
            visited[boss[building]] = true;
            K -= stone;
            if (K < 0) {
                break;
            }
            // System.out.println(K);
            rank--;
            if (rank == 1) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}