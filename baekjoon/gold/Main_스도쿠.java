package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_스도쿠 {
    static StringBuilder sb = new StringBuilder();
    static int empty;
    static int N = 9;
    static int[][] paper = new int[N][N];

    static LinkedList<Integer>[] row;
    static LinkedList<Integer>[] col;
    static LinkedList<Integer>[] block;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        row = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            row[i] = new LinkedList<>();
        }
        col = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            col[i] = new LinkedList<>();
        }
        block = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            block[i] = new LinkedList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
                if (paper[i][j] == 0) {
                    row[i].add(j);
                    col[j].add(i);
                    int tmp = (i / 3) * 3 + j / 3;
                    block[tmp].add(null);
                }
            }
        }
        // for (int i = 0; i < row.size(); i++) {
        // System.out.print(row.get(i));
        // }
        // System.out.println();
        // for (int i = 0; i < col.size(); i++) {
        // System.out.print(col.get(i));
        // }
        // System.out.println();
        // for (int i = 0; i < block.size(); i++) {
        // System.out.print(block.get(i));
        // }
    }
}
