package baekjoon_v2.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_그림 {
    static int N, M;
    static boolean[][] paper;
    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };
    static int max = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    paper[i][j] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (paper[i][j]) {
                    result++;
                    ArrayDeque<Integer[]> q = new ArrayDeque<>();
                    q.add(new Integer[] { i, j });
                    paper[i][j] = false;
                    int cnt = 0;
                    while (!q.isEmpty()) {
                        cnt++;
                        Integer[] tmp = q.poll();
                        int r = tmp[0];
                        int c = tmp[1];

                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if (isout(nr, nc)) {
                                continue;
                            }

                            if (paper[nr][nc]) {
                                q.add(new Integer[] { nr, nc });
                                paper[nr][nc] = false;
                            }
                        }
                    }
                    max = Math.max(max, cnt);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(result);
        sb.append("\n");
        sb.append(max);
        System.out.println(sb);
    }

    private static boolean isout(int nr, int nc) {
        return nr < 0 || nr >= N || nc < 0 || nc >= M;
    }
}
