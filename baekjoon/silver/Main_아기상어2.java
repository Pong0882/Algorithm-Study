package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_아기상어2 {
    static int N, M;
    static int paper[][];
    static int result;
    static ArrayDeque<Integer[]> q;
    static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
                if (paper[i][j] == 1) {
                    q.add(new Integer[] { i, j });
                }
            }
        }
        while (!q.isEmpty()) {
            Integer[] tmp = q.poll();
            int r = tmp[0];
            int c = tmp[1];
            int time = paper[r][c];
            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (!check(nr, nc)) {
                    continue;
                }
                if (paper[nr][nc] == 0) {
                    paper[nr][nc] = time + 1;
                    q.add(new Integer[] { nr, nc });
                }
            }
        }

        for (int i = 0; i < N; i++) {
            // System.out.println(Arrays.toString(paper[i]));
            for (int j = 0; j < M; j++) {
                result = Math.max(result, paper[i][j]);
            }
        }
        System.out.println(result - 1);
    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < M;
    }
}
