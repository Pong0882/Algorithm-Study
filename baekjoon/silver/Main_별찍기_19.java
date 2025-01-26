package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_별찍기_19 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int[][] paper;
    private static int N;
    private static int depth = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        int size = 1 + (N - 1) * 4;
        paper = new int[size][size];

        for (int i = size / 2; i >= 0; i -= 2) {
            Star(i);
            depth++;
        }

        for (int i = 0; i < paper.length; i++) {
            for (int j = 0; j < paper.length; j++) {
                if (paper[i][j] == 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    private static void Star(int start) {
        int r = depth * 4;

        for (int i = start; i <= start + r; i++) {
            paper[start][i] = 1;
            paper[i][start] = 1;
            paper[start + r][i] = 1;
            paper[i][start + r] = 1;
        }
    }
}
