package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_별찍기_18 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int A, B, N, M, F, result;
    private static int[][] paper;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        F = Facto(2);
        A = Facto(2) - 1;
        B = A * 2 - 1;
        paper = new int[A][B];

        Star(A, B);
        // Star2();

        Print();
    }

    private static void Star(int r, int c) {
        if (N == 0) {
            return;
        }
        if (N % 2 == 0) {
        } else {
            System.out.println(N + " : " + r + " ," + c);
            System.out.println(c - 1 + " ~ " + (B - c - 1));

            for (int i = c - 1; i > B - c; i--) {
                paper[r - 1][i] = 1;
            }
        }
        N--;
        Star(r * 3 / 4, (B / 2) + (c * 1 / 8));
    }

    private static void Print() {
        for (int i = 0; i < paper.length; i++) {
            for (int j = 0; j < F * 2 - 3; j++) {
                if (paper[i][j] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println("");
        }
    }

    private static int Facto(int n) {
        int result = 1;
        for (int i = 1; i <= N; i++) {
            result *= n;
        }
        return result;
    }

}
