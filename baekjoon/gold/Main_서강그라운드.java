package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_서강그라운드 {
    static int N, M, R;
    static int[][] paper;
    static int[] item;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        item = new int[N + 1];
        paper = new int[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            item[i + 1] = Integer.parseInt(st.nextToken());
        }
        // System.out.println(Arrays.toString(item));
        // System.out.println();
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(paper[i], Integer.MAX_VALUE / 100);
            paper[i][i] = 0;
        }
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            paper[s][e] = w;
            paper[e][s] = w;
        }

        // 플로이드 와샬
        // for (int i = 0; i < N + 1; i++) {
        // System.out.println(Arrays.toString(paper[i]));
        // }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    paper[i][j] = Math.min(paper[i][k] + paper[k][j], paper[i][j]);
                }
            }
        }
        // System.out.println();
        // for (int i = 0; i < N + 1; i++) {
        // System.out.println(Arrays.toString(paper[i]));
        // }

        for (int i = 1; i < N + 1; i++) {
            int tmp = 0;
            for (int j = 1; j < N + 1; j++) {
                if (paper[i][j] <= M) {
                    tmp += item[j];
                }
            }
            // System.out.println(tmp);
            if (tmp > result) {
                result = tmp;
            }
        }
        System.out.println(result);
    }
}
