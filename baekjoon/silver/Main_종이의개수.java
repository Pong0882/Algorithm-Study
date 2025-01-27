package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_종이의개수 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N;
    private static int[] result;
    private static int[][] paper;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        result = new int[3]; // -1, 0, 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rec(0, 0, N);

        for (int i = 0; i < 3; i++) {
            System.out.println(result[i]);
        }
    }

    private static void rec(int r, int c, int size) {
        if (check(r, c, size)) {
            result[paper[r][c] + 1]++;
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rec(r + i * newSize, c + j * newSize, newSize);
            }
        }
    }

    private static boolean check(int r, int c, int size) {
        int val = paper[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (paper[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}