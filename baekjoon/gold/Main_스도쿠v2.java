package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_스도쿠v2 {

    static StringBuilder sb = new StringBuilder();
    static int N = 9;
    static int[][] paper = new int[N][N];
    static boolean[] check;
    static LinkedList<Integer[]> empty = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
                if (paper[i][j] == 0) {
                    empty.add(new Integer[] { i, j });
                }
            }
        }

        for (int i = 0; i < empty.size(); i++) {
            Integer[] tmp = empty.get(i);
            int r = tmp[0];
            int c = tmp[1];
            System.out.println(r + " " + c);
        }
        sudoku();
    }

    private static void sudoku() {
        while (!empty.isEmpty()) {
            for (int re = 0; re < empty.size(); re++) {
                Integer[] tmp = empty.get(re);
                int r = tmp[0];
                int c = tmp[1];
                // checkRow(r, c);
                // checkCol(r, c);
                // checkBlock(r, c);
            }
        }
    }

    private static void checkRow(int r, int c) {
        check = new boolean[N];
        for (int i = 0; i < 9; i++) {
        }
    }
}
