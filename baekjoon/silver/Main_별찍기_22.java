package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_별찍기_22 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int A, B, N, M, result;
    private static int[][] paper;

    private static int r, c;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println("*");
        } else {
            c = (N - 1) * 4 + 1;
            r = c + 2;

            paper = new int[r][c];

            int cnt = 0;
            int x = 0;
            int y = c - 1;
            while (cnt <= N * 4 - 2) {
                // System.out.print(cnt);
                if (cnt % 4 == 0) {
                    while (y > cnt / 2) {
                        paper[x][y--] = 1;
                    }
                }
                if (cnt % 4 == 1) {
                    while (x < r - cnt / 2) {
                        paper[x++][y] = 1;
                    }
                    x--;
                }
                if (cnt % 4 == 2) {

                    while (y <= c - cnt / 2) {
                        paper[x][y++] = 1;
                    }

                    y--;
                }
                if (cnt % 4 == 3) {
                    while (x > cnt / 2) {
                        paper[x--][y] = 1;
                    }
                    x++;
                }
                cnt++;
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 1 && j == 1) {
                    break;
                }
                if (paper[i][j] == 1)
                    sb.append("*");
                else
                    sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
