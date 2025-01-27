package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_별찍기_9 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int A, B, N, M, result;
    private static int[] paper;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N * 2 - 1; i++) {
            for (int j = 0; j < -Math.abs(-(i - (N - 1))) + (N - 1); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < Math.abs(-2 * (i - (N - 1))) + 1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
