package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_별찍기_12 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int A, B, N, M, result;
    private static int[] paper;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i < N * 2; i++) {
            for (int j = 0; j < Math.abs(i - N); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < -Math.abs(i - N) + N; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
