package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_내리막길Fail {
    static int N, M;
    static int[][] paper;
    static int[][] dp;
    static int[] dr = { 0, 0, -1, 1 };
    static int[] dc = { 1, -1, 0, 0 };

    static class block implements Comparable<block> {
        int r, c, w;

        public block(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }

        @Override
        public int compareTo(block o) {
            return Integer.compare(o.w, w);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<block> pq = new PriorityQueue<>();
        pq.add(new block(0, 0, paper[0][0]));
        dp[0][0] = 1;
        while (!pq.isEmpty()) {
            block tmp = pq.poll();
            int r = tmp.r;
            int c = tmp.c;
            block tmp2 = pq.peek();
            // if (tmp2 != null) {
            // if (r == tmp2.r && c == tmp2.c) {
            // continue;
            // }
            // }
            // System.out.println(r + " " + c + " " + tmp.w);
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (!check(nr, nc)) {
                    continue;
                }
                int nw = paper[nr][nc];
                if (paper[r][c] > paper[nr][nc]) {
                    pq.add(new block(nr, nc, nw));
                    dp[nr][nc]++;
                    // System.out.println();
                }
            }
            // for (int j = 0; j < N; j++) {
            // System.out.println(Arrays.toString(dp[j]));
            // }
            // System.out.println();
        }
        System.out.println(dp[N - 1][M - 1]);
    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < M;
    }
}
