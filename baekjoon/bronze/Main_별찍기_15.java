package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_별찍기_15 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int A, B, N, M, result;
    private static int[] paper;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N - i; j++) {
                System.out.print(" ");

            }
            System.out.print("*");
            if (i == 1) {
                System.out.println("");
                continue;
            }
            for (int j = 0; j < 2 * (i - 1) - 1; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
    }
}
