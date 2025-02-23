package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_불v2 {
    static StringBuilder sb = new StringBuilder();
    static int R, C;
    static int[][] paper;
    static int[] dr = { 1, -1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };
    static int sr, sc;
    static Queue<Integer[]> fire = new ArrayDeque<>();
    static Queue<Integer[]> m = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        paper = new int[R][C];

        for (int i = 0; i < R; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                int tmp = c[j];
                if (tmp == '#') {
                    paper[i][j] = 1000000;
                } else if (tmp == 'F') {
                    paper[i][j] = -1;
                    fire.add(new Integer[] { i, j });
                } else if (tmp == '.') {
                    paper[i][j] = 0;
                } else if (tmp == 'J') {
                    sr = i;
                    sc = j;
                    m.add(new Integer[] { i, j });
                }
            }
        }
        goFire();
        // for (int i = 0; i < R; i++) {
        // System.out.println(Arrays.toString(paper[i]));
        // }
        int result = goMan();
        System.out.println(result == -1 ? "IMPOSSIBLE" : result - 1);
        // for (int i = 0; i < R; i++) {
        // System.out.println(Arrays.toString(paper[i]));
        // }
    }

    private static int goMan() {
        paper[sr][sc] = 2;
        while (!m.isEmpty()) {
            Integer[] tmp = m.poll();
            int r = tmp[0];
            int c = tmp[1];
            int time = paper[r][c];
            if (endGame(r, c)) {
                return time;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (!check(nr, nc)) {
                    continue;
                }
                if (paper[nr][nc] < -time || paper[nr][nc] == 0) {
                    paper[nr][nc] = time + 1;
                    m.add(new Integer[] { nr, nc });
                }
            }
        }
        return -1;
    }

    private static boolean endGame(int r, int c) {
        return r == 0 || r == R - 1 || c == 0 || c == C - 1;
    }

    private static void goFire() {
        while (!fire.isEmpty()) {
            Integer[] tmp = fire.poll();
            int r = tmp[0];
            int c = tmp[1];
            int time = paper[r][c];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (!check(nr, nc)) {
                    continue;
                }
                if (paper[nr][nc] == 0) {
                    paper[nr][nc] = time - 1;
                    fire.add(new Integer[] { nr, nc });
                }
            }
        }
    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < R && nc < C;
    }
}