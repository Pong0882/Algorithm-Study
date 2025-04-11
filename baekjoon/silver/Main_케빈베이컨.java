package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_케빈베이컨 {
    static int N, M;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(paper[i], 1000);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            paper[a][b] = 1;
            paper[b][a] = 1;
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    paper[i][j] = Math.min(paper[i][j], paper[i][k] + paper[k][j]);
                }
            }
        }

        int result = 0;
        int sum = 10000;
        for (int i = 1; i < N + 1; i++) {
            int tmp = 0;
            for (int j = 1; j < N + 1; j++) {
                if (i != j)
                    tmp += paper[i][j];
            }
            if (sum > tmp) {
                sum = tmp;
                result = i;
            }
        }
        System.out.println(result);
        // for (int i = 0; i < N; i++) {
        // for (int z = 0; z < N; z++) {
        // if (paper[i + 1][z + 1] == 10000) {
        // System.out.print(-1 + " ");
        // } else
        // System.out.print(paper[i + 1][z + 1] + " ");
        // }
        // System.out.println();
        // }
    }
}
