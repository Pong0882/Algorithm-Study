package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2447 {
    private static int n;
    private static int[][] paper;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static void hole(int r, int c, int n) {
        if (n == 1) {
            return;
        }
        n /= 3;
        for (int i = r + n; i < r + n * 2; i++) {
            for (int j = c + n; j < c + n * 2; j++) {
                paper[i][j] = 1;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                hole(r + n * i, c + n * j, n);
            }
        }
        return;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        hole(0, 0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (paper[i][j] == 0) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
