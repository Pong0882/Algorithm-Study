package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_봄버맨2 {

    static int[][] paper;

    static int R, C, N;
    static int[] dr = { 1, -1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };
    static ArrayDeque<Integer[]> boom = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        paper = new int[R][C];
        int max = N;
        for (int i = 0; i < R; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (c[j] == '.') {
                    paper[i][j] = 0;
                } else {
                    paper[i][j] = 2;
                }
            }
        }

        if (N == 1) {
            printPaper();
            return;
        }
        fullBoom();
        if (N % 2 == 0) {
            printPaper();
            return;
        }
        oneSec();
        if (N % 4 == 3) {
            printPaper();
            return;
        }
        fullBoom();
        oneSec();
        if (N % 4 == 1) {
            printPaper();
            return;
        }
    }

    private static void fullBoom() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (paper[i][j] == 0) {
                    paper[i][j] = 3;
                } else {
                    paper[i][j]--;
                }
            }
        }
    }

    private static void oneSec() {
        ArrayDeque<Integer[]> boom = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (paper[i][j] == 1) {
                    boom.add(new Integer[] { i, j });
                }
                if (paper[i][j] > 0) {
                    paper[i][j]--;
                }
            }
        }
        while (!boom.isEmpty()) {
            Integer[] tmp = boom.poll();
            int r = tmp[0];
            int c = tmp[1];
            paper[r][c] = 0;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (!check(nr, nc)) {
                    continue;
                }
                paper[nr][nc] = 0;
            }
        }
    }

    private static void printPaper() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            // System.out.println(Arrays.toString(paper[i]));
            for (int j = 0; j < C; j++) {
                sb.append(paper[i][j] > 0 ? "O" : ".");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static boolean check(int a, int b) {
        // TODO Auto-generated method stub
        return a >= 0 && b >= 0 && a < R && b < C;
    }

}
