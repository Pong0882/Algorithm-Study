package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_보물섬 {
    static StringBuilder sb = new StringBuilder();
    static int R, C;
    static int[][] paper;
    static int[][] visited;
    static int result;
    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        paper = new int[R][C];
        for (int i = 0; i < R; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (c[j] == 'W') {
                    paper[i][j] = -1;
                } else {
                    paper[i][j] = 0;
                }
            }
        }
        // for (int i = 0; i < R; i++) {
        // System.out.println(Arrays.toString(paper[i]));
        // }
        ///////////////////////////////////
        gogo();
        System.out.println(result - 1);
    }

    private static void gogo() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                visited = new int[R][C];
                int cnt = 1;
                if (visited[i][j] != 0 || paper[i][j] == -1)
                    continue;
                int maxCnt = 0;
                Queue<Integer[]> queue = new ArrayDeque<>();
                queue.add(new Integer[] { i, j });
                visited[i][j] = cnt;
                while (!queue.isEmpty()) {
                    Integer[] tmp = queue.poll();
                    int r = tmp[0];
                    int c = tmp[1];
                    cnt = visited[r][c] + 1;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (!check(nr, nc))
                            continue;

                        if (visited[nr][nc] != 0 || paper[nr][nc] == -1)
                            continue;

                        visited[nr][nc] = cnt;
                        queue.add(new Integer[] { nr, nc });

                        result = Math.max(result, cnt);
                    }
                }
                // for (int k = 0; k < R; k++) {
                // System.out.println(Arrays.toString(visited[k]));
                // }
                // System.out.println();
            }
        }
    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < R && nc < C;
    }
}
