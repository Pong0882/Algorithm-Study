package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_달팽이 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int TC = 1; TC <= T; TC++) {
            int N = Integer.parseInt(br.readLine());

            int[][] paper = new int[N][N];
            int cnt = 1;
            int d = 0;
            int[] dr = { 0, 1, 0, -1 };
            int[] dc = { 1, 0, -1, 0 };
            int size = N;
            paper[0][0] = 1;
            int r = 0;
            int c = -1;

            while (cnt <= N * N) {
                for (int i = 0; i < size; i++) {
                    r = r + dr[d];
                    c = c + dc[d];
                    paper[r][c] = cnt++;
                }
                d++;
                d %= 4;
                if (d % 2 == 1) {
                    size--;
                }
            }

            sb.append("#").append(TC).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(paper[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
