package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_보물섬v2 {
    static StringBuilder sb = new StringBuilder();
    static int R, C;
    static int[][] paper;
    static int[][] visited;
    static int result;
    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        paper = new int[R][C];
        for (int i = 0; i < R; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (c[j] == 'W') {
                    paper[i][j] = -1;
                } else {
                    paper[i][j] = 0;
                }
            }
        }
        // for (int i = 0; i < R; i++) {
        // System.out.println(Arrays.toString(paper[i]));
        // }
        ///////////////////////////////////
        visited = new bool[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (paper[i][j] == 0) {
                    visited[i][j] = true;

                }
            }
        }
    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < R && nc < C;
    }
}
