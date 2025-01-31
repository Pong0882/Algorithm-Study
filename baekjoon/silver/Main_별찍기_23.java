package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_별찍기_23 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int A, B, N, M, result;
    private static int[][] paper;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i < 2 * N; i++) {
            for (int j = 0; j < -Math.abs(i - N) + N - 1; j++) {
                System.out.print(" ");
            }
            System.out.print("*");

            for (int j = 0; j < N - 2; j++) {
                if (i == 1 || i == 2 * N - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("*");

            for (int j = 0; j < Math.abs(-2 * (i - N)) - 1; j++) {
                System.out.print(" ");
            }
            if (i != N) {
                System.out.print("*");
            }
            for (int j = 0; j < N - 2; j++) {
                if (i == 1 || i == 2 * N - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("*");

            System.out.println("");
        }
    }
}
