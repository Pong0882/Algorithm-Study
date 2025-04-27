package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_영상처리 {
    static int N, M;
    static int[][] paper;
    static int[][] pixel;
    static int result;
    static int bound;

    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        pixel = new int[N][M * 3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M * 3; j++) {
                pixel[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bound = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int tmp = 0;
                for (int j2 = 0; j2 < 3; j2++) {
                    tmp += pixel[i][j * 3 + j2];
                }
                tmp /= 3;
                if (tmp >= bound) {
                    paper[i][j] = 3;
                }
            }
        }

        // for (int i = 0; i < N; i++) {
        // System.out.println(Arrays.toString(paper[i]));
        // }

        ArrayDeque<Integer[]> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (paper[i][j] == 3) {
                    result++;
                    q.add(new Integer[] { i, j });
                    paper[i][j] += 10;
                    while (!q.isEmpty()) {
                        Integer[] tmp = q.poll();
                        int r = tmp[0];
                        int c = tmp[1];
                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if (!check(nr, nc)) {
                                continue;
                            }
                            if (paper[nr][nc] == 3) {
                                q.add(new Integer[] { nr, nc });
                                paper[nr][nc] += 10;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }

    private static boolean check(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
