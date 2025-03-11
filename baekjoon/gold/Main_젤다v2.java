package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_젤다v2 {
    static class point implements Comparable<point> {
        int r, c, w;

        public point(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }

        @Override
        public int compareTo(point o) {
            return Integer.compare(w, o.w);
        }

    }

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] paper;
    static int[] dr = { 1, -1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };
    static int result;
    static int[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = 0;
        while (true) {
            T++;
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            paper = new int[N][N];
            dp = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    paper[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<point> points = new PriorityQueue<>();

            points.add(new point(0, 0, paper[0][0]));
            dp[0][0] = paper[0][0];
            while (!points.isEmpty()) {
                point tmp = points.poll();
                int r = tmp.r;
                int c = tmp.c;
                int w = tmp.w;
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (!check(nr, nc)) {
                        continue;
                    }
                    if (dp[nr][nc] <= w + paper[nr][nc]) {
                        continue;
                    }
                    dp[nr][nc] = dp[r][c] + paper[nr][nc];
                    // for (int j = 0; j < N; j++) {
                    // System.out.println(Arrays.toString(dp[j]));
                    // }
                    points.add(new point(nr, nc, dp[r][c] + paper[nr][nc]));
                }
            }
            sb.append("Problem ").append(T).append(": ").append(dp[N - 1][N - 1]).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < N;
    }
}
