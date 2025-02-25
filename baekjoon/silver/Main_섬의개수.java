package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_섬의개수 {
    static StringBuilder sb = new StringBuilder();
    static int R, C;
    static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
    static int result;
    static boolean[][] visited;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            if (R == 0 && C == 0) {
                break;
            }
            result = 1;
            paper = new int[R][C];
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    paper[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (paper[i][j] == 1) {
                        result++;
                        ArrayDeque<Integer[]> queue = new ArrayDeque<>();
                        queue.add(new Integer[] { i, j });
                        paper[i][j] = result;
                        while (!queue.isEmpty()) {
                            Integer[] tmp = queue.poll();
                            int r = tmp[0];
                            int c = tmp[1];
                            for (int d = 0; d < 8; d++) {
                                int nr = r + dr[d];
                                int nc = c + dc[d];
                                if (!check(nr, nc)) {
                                    continue;
                                }
                                if (paper[nr][nc] == 1) {
                                    queue.add(new Integer[] { nr, nc });
                                    paper[nr][nc] = result;
                                }
                            }
                        }
                    }
                }
            }
            // for (int i = 0; i < R; i++) {
            // System.out.println(Arrays.toString(paper[i]));
            // }
            sb.append(result - 1).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < R && nc < C;
    }
}