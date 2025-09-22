package baekjoon_v2.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_미로탐색 {
    static int[] dr = { 0, 0, -1, 1 };
    static int[] dc = { 1, -1, 0, 0 };
    static int N, M;

    static boolean[][] paper;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new boolean[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < c.length; j++) {
                if (c[j] == '1') {
                    paper[i][j] = true;
                }
            }
        }

        ArrayDeque<Integer[]> q = new ArrayDeque<>();
        q.add(new Integer[] { 0, 0, 1 });
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Integer[] tmp = q.poll();
            int r = tmp[0];
            int c = tmp[1];
            int t = tmp[2];

            if (r == N - 1 && c == M - 1) {
                System.out.println(t);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (isout(nr, nc)) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }
                if (paper[nr][nc]) {
                    q.add(new Integer[] { nr, nc, t + 1 });
                    visited[nr][nc] = true;
                }
            }
        }
    }

    private static boolean isout(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= M;
    }
}
