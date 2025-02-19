package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_안전영역 {
    private static int N;
    private static int[][] paper;
    private static int[][] land;
    private static int[] dr = { 0, 0, 1, -1 };
    private static int[] dc = { 1, -1, 0, 0 };
    private static int result;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        land = new int[N][N];
        paper = new int[N][N];
        int height = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
                height = Math.max(height, paper[i][j]);
            }
        }
        // System.out.println(height);
        result = 1;
        for (int h = 1; h < height; h++) { // 수위
            int cnt = 0;
            for (int i = 0; i < args.length; i++) {
                for (int j = 0; j < args.length; j++) {
                    if (paper[i][j] > h && land[i][j] < h) {
                        cnt++;
                        Queue<Integer[]> queue = new ArrayDeque<>();
                        queue.add(new Integer[] { i, j });
                        land[i][j] = h;
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
                                land[nr][nc] = h;
                                queue.add(new Integer[] { nr, nc });
                            }
                        }
                    }
                }
            }
            result = Math.max(result, cnt);
        }
        System.out.println(result);
    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < N;
    }
}
