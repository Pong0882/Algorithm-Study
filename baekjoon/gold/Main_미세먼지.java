package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_미세먼지 {
    static int R, C, T;
    static int[][] paper;
    static int result;
    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };
    static int purir, puric;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        paper = new int[R][C];
        ArrayDeque<int[]> dust = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
                if (paper[i][j] >= 5) {
                    dust.add(new int[] { i, j, paper[i][j] });
                }
                if (paper[i][j] == -1) {
                    purir = i;
                    puric = j;
                }
            }
        }
        // 미세먼지 후~
        while (!dust.isEmpty()) {
            int[] tmp = dust.poll();
            int r = tmp[0];
            int c = tmp[1];
            int bigDust = tmp[2];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (!check(nr, nc)) {
                    continue;
                }
                if (paper[nr][nc] == -1) {
                    continue;
                }
                paper[nr][nc] += bigDust / 5;
                paper[r][c] -= bigDust / 5;
            }
        }

        // 공청기 작동!
        for (int i = purir - 2; i >= 0; i--) { // 위이동
            paper[i + 1][0] = paper[i][0];
        }
        for (int i = 1; i < C; i++) {
            paper[0][i - 1] = paper[0][i];
        }
        for (int i = 0; i < purir - 1; i++) {
            paper[i][C - 1] = paper[i + 1][C - 1];
        }
        for (int i = C - 1; i > 0; i--) {
            paper[purir - 1][i] = paper[purir - 1][i - 1];
        }
        ////////////////////
        for (int i = purir - 1; i < R - 1; i++) {
            paper[i][0] = paper[i + 1][0];
        }
        for (int i = 1; i < C; i++) {
            paper[R - 1][i - 1] = paper[R - 1][i];
        }
        for (int i = R - 1; i > purir; i--) {
            paper[i][C - 1] = paper[i - 1][C - 1];
        }
        for (int i = C - 1; i > 0; i--) {
            paper[purir][i] = paper[purir][i - 1];
        }

        /////////////////////
        for (int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(paper[i]));
        }

    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < R && nc < C;
    }
}
