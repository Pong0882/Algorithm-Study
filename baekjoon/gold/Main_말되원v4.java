package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_말되원v4 {
    static int S, R, C;
    static int[][] paper;
    static boolean[][][] visited;
    static int[] dr = { 0, 0, 1, -1, -1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] dc = { 1, -1, 0, 0, -2, -1, 1, 2, 2, 1, -1, -2 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        S = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        paper = new int[R][C];
        visited = new boolean[R][C][S + 1];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] { 0, 0, 0, S });
        visited[0][0][S] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int r = tmp[0];
            int c = tmp[1];
            int t = tmp[2];
            int s = tmp[3];

            if (r == R - 1 && c == C - 1) {
                System.out.println(t);
                return;
            }

            for (int i = 0; i < 12; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (!check(nr, nc) || paper[nr][nc] == 1)
                    continue;

                if (i >= 4 && s > 0 && !visited[nr][nc][s - 1]) {
                    q.add(new int[] { nr, nc, t + 1, s - 1 });
                    visited[nr][nc][s - 1] = true;
                } else if (i < 4 && !visited[nr][nc][s]) {
                    q.add(new int[] { nr, nc, t + 1, s });
                    visited[nr][nc][s] = true;
                }
            }
        }

        System.out.println(-1);
    }

    private static boolean check(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
