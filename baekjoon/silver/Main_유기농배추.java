package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_유기농배추 {
    static int T, N, M, K;
    static int[][] paper;
    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for (int TC = 0; TC < T; TC++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            paper = new int[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                paper[a][b] = 1;
            }
            int result = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (paper[i][j] == 1) {
                        result++;
                        Queue<Integer[]> queue = new ArrayDeque<>();
                        queue.add(new Integer[] { i, j });
                        paper[i][j] = result;
                        while (!queue.isEmpty()) {
                            Integer[] tmp = queue.poll();
                            int r = tmp[0];
                            int c = tmp[1];
                            for (int k = 0; k < 4; k++) {
                                int nr = r + dr[k];
                                int nc = c + dc[k];
                                if (!check(nr, nc)) {
                                    continue;
                                }
                                if (paper[nr][nc] == 1) {
                                    paper[nr][nc] = result;
                                    queue.add(new Integer[] { nr, nc });
                                }
                            }
                        }
                    }
                }
            }
            sb.append(result - 1).append("\n");
            // for (int i = 0; i < N; i++) {
            // System.out.println(Arrays.toString(paper[i]));
            // }

        }
        System.out.println(sb);
    }

    private static boolean check(int a, int b) {
        return a >= 0 && b >= 0 && a < N && b < M;
    }
}
