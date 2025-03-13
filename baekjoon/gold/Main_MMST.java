package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_MMST {
    static int N, M;
    static int[] boss;
    static int[][] dp;

    static class Edge implements Comparable<Edge> {
        int s, e, w, num;

        public Edge(int s, int e, int w, int num) {
            this.s = s;
            this.e = e;
            this.w = w;
            this.num = num;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(w, o.w);
        }
    }

    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static PriorityQueue<Edge> pq2 = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boss = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            boss[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Edge(s, e, w, i + 1));
        }
        dp = new int[3][N];
        int cnt = 0;
        while (!pq.isEmpty() || !pq2.isEmpty()) {
            if (cnt == N - 1) {
                while (!pq.isEmpty()) {
                    pq2.add(pq.poll());
                    if (pq2.size() >= 2) {
                        break;
                    }
                }
                if (pq2.size() >= 2) {
                    Edge tmp2 = pq2.poll();
                    for (int i = 0; i < N; i++) {
                        if (dp[1][i] == tmp2.e) {
                            if (dp[2][i] == tmp2.w) {
                                break;
                            }
                            dp[2][i] = tmp2.num;
                            break;
                        }
                    }
                    System.out.println("YES");
                    for (int i = 0; i < N - 1; i++) {
                        sb.append(dp[2][i]).append(" ");
                    }
                    System.out.println(sb);
                    // System.out.println(sb);
                    // for (int i = 0; i < 3; i++) {
                    // System.out.println(Arrays.toString(dp[i]));
                    // }
                    return;
                }
                break;
            }
            Edge tmp = pq.poll();
            if (union(tmp.s, tmp.e)) {
                // sb.append(tmp.num).append(" ");
                dp[0][cnt] = tmp.s;
                dp[1][cnt] = tmp.e;
                dp[2][cnt] = tmp.num;
                cnt++;
            } else {
                pq2.add(new Edge(tmp.s, tmp.e, tmp.w, tmp.num));
            }
        }
        System.out.println("NO");
    }

    private static boolean union(int s, int e) {
        int bossA = bf(s);
        int bossB = bf(e);
        if (bossA == bossB) {
            return false;
        }
        boss[bossA] = bossB;
        return true;

    }

    private static int bf(int s) {
        if (s == boss[s]) {
            return s;
        }
        return boss[s] = bf(boss[s]);
    }
}
