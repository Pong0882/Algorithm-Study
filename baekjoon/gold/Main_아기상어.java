package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_아기상어 {
    static int N;
    static int[][] paper;
    static int sharkSize, hungry;

    static int[] dr = { -1, 0, 0, 1 };
    static int[] dc = { 0, -1, 1, 0 };
    static int sr, sc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
                if (paper[i][j] == 9) {
                    sr = i;
                    sc = j;
                    paper[i][j] = 0;
                }
            }
        }

        sharkSize = 2;
        hungry = sharkSize;
        gogo();
    }

    private static void gogo() {
        ArrayDeque<Integer[]> que = new ArrayDeque<>();
        que.add(new Integer[] { sr, sc });
        while (!que.isEmpty()) {
            Integer[] tmp = que.poll();
            int r = tmp[0];
            int c = tmp[1];
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (!check(nr, nc)) {
                    continue;
                }
                if (paper[nr][nc] > sharkSize) {
                    continue;
                }
                if (paper[nr][nc] < sharkSize) {

                }
            }
        }

    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < N;
    }
}
