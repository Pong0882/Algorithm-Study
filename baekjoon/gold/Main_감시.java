package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_감시 {
    static int R, C;
    static int[][] paper;
    static int d;
    static boolean[][] visited;
    static boolean[][] copy;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static List<Integer[]> cctv = new ArrayList<>();
    static int result = 100;
    static StringBuilder sb = new StringBuilder();
    static int[] selectD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        paper = new int[R][C];
        visited = new boolean[R][C];
        copy = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
                if (paper[i][j] >= 1 && paper[i][j] <= 5) {
                    visited[i][j] = true;
                    cctv.add(new Integer[] { paper[i][j], i, j });
                } else if (paper[i][j] == 6) {
                    visited[i][j] = true;
                }
            }
        }
        selectD = new int[cctv.size()];
        gogo(0, 0);
        System.out.println(result);
    }

    private static void gogo(int index, int rotation) {
        if (index == cctv.size()) {
            // System.out.println(Arrays.toString(selectD));
            checking();
            return;
        }

        for (int j = 0; j < 4; j++) {
            selectD[index] = j;
            gogo(index + 1, j);
        }
    }

    private static void checking() {
        for (int i = 0; i < R; i++) {
            copy[i] = visited[i].clone();
        }
        for (int index = 0; index < cctv.size(); index++) {
            Integer[] cur = cctv.get(index);
            int type = cur[0];
            int r = cur[1];
            int c = cur[2];
            int rotation = selectD[index];

            // System.out.println("index:" + index + " type:" + type + " rotation" +
            // rotation);
            switch (type) {
                case 1:
                    one(rotation, r, c);
                    break;
                case 2:
                    two(rotation, r, c);
                    break;
                case 3:
                    three(rotation, r, c);
                    break;
                case 4:
                    four(rotation, r, c);
                    break;
                case 5:
                    five(rotation, r, c);
                    break;
            }
        }
        int tmp = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!copy[i][j]) {
                    tmp++;
                }
            }
        }
        // System.out.println(result);
        result = Math.min(tmp, result);
    }

    private static void five(int rotation, int r, int c) {
        observe(rotation, r, c);
        observe((rotation + 1) % 4, r, c);
        observe((rotation + 2) % 4, r, c);
        observe((rotation + 3) % 4, r, c);
    }

    private static void four(int rotation, int r, int c) {
        observe(rotation, r, c);
        observe((rotation + 1) % 4, r, c);
        observe((rotation + 2) % 4, r, c);
    }

    private static void three(int rotation, int r, int c) {
        observe(rotation, r, c);
        observe((rotation + 1) % 4, r, c);
    }

    private static void two(int rotation, int r, int c) {
        observe(rotation, r, c);
        observe((rotation + 2) % 4, r, c);
    }

    private static void one(int rotation, int r, int c) {
        observe(rotation, r, c);
    }

    private static void observe(int d, int r, int c) {
        int nr = r;
        int nc = c;
        while (true) {
            nr += dr[d];
            nc += dc[d];
            if (!outCheck(nr, nc)) {
                return;
            } else if (wallCheck(nr, nc)) {
                return;
            }
            copy[nr][nc] = true;
        }
    }

    private static boolean wallCheck(int r, int c) {
        return paper[r][c] == 6;
    }

    private static boolean outCheck(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < R && nc < C;
    }
}