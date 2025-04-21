package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_알고스팟 {
    static int M, N;
    static int[][] paper;
    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                paper[i][j] = c[j] - '0';
                if (paper[i][j] == 1) {
                    paper[i][j] = -1;
                }
            }
        }
        ArrayDeque<Integer[]> q = new ArrayDeque<>();
        ArrayDeque<Integer[]> q2 = new ArrayDeque<>();
        q.add(new Integer[] { 0, 0 });
        int result = 1;
        while (!q.isEmpty()) {
            Integer[] tmp = q.poll();
            int r = tmp[0];
            int c = tmp[1];
            if (r == N - 1 && c == M - 1) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (!check(nr, nc)) {
                    continue;
                }
                if (paper[nr][nc] == -1) {
                    q2.add(new Integer[] { nr, nc });
                } else if (paper[nr][nc] == result) {
                    paper[nr][nc] = result + 1;
                    q.add(new Integer[] { nr, nc });
                }
            }
            if (q.isEmpty()) {
                while (!q2.isEmpty()) {
                    Integer[] tmp2 = q2.poll();
                    int a = tmp2[0];
                    int b = tmp2[1];
                    paper[a][b] = result;
                }
                result++;
            }
        }
        System.out.println(result);
    }

    private static boolean check(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
