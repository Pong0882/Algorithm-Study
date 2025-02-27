package SWEA.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_프로세서 {
    static int N;
    static int[][] paper;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static List<Integer[]> core;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int TC = 1; TC <= T; TC++) {
            N = Integer.parseInt(br.readLine());
            paper = new int[N][N];
            core = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    paper[i][j] = Integer.parseInt(st.nextToken());
                    if (paper[i][j] == 1 && i != 0 && j != 0 && i != N - 1 && j != N - 1)
                        core.add(new Integer[] { i, j });
                }
            }
            go(0, 0);
        }
    }

    private static void go(int idx, int d) {
        if (idx == core.size()) {
            return;
        }
        Integer[] tmp = core.get(idx);
        int r = tmp[0];
        int c = tmp[1];
        System.out.println("r:" + r + " / c: " + c + " / idx : " + idx + " / d : " + d);
        go(idx + 1, 0);
        go(idx + 1, 1);
        go(idx + 1, 2);
        go(idx + 1, 3);
    }
}
