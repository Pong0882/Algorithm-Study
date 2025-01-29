package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_N_Queen {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int A, B, N, M, result;
    private static int[][] paper;

    private static boolean[] YVisited;
    private static int[] floor;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        YVisited = new boolean[N];
        floor = new int[N];
        Queen(0, 0);
        System.out.println(result);
    }

    private static void Queen(int x, int y) {
        if (x == N) {
            result++;
            return;
        }

        a: for (int i = 0; i < N; i++) {
            if (!YVisited[i]) {
                for (int j = 0; j < x; j++) {
                    if (Math.abs(floor[j] - i) == Math.abs(j - x))
                        continue a;
                }
                YVisited[i] = true;
                floor[x] = i;
                Queen(x + 1, i);
                YVisited[i] = false;
            }
        }
    }
}
