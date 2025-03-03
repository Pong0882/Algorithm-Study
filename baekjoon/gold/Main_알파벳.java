package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_알파벳 {
    static int R, C;
    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };
    static int[][] paper;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        paper = new int[R][C];
        visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                paper[i][j] = c[j] - 'A';
            }
        }

        ArrayDeque<Integer[]> q = new ArrayDeque<>();
        q.add(new Integer[] { 0, 0 });
        visited[paper[0][0]] = true;
        int result = 0;
        while (!q.isEmpty()) {
            result++;
            Integer[] tmp = q.poll();
            int r = tmp[0];
            int c = tmp[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (!check(nr, nc))
                    continue;

                if (!visited[paper[nr][nc]]) {
                    q.add(new Integer[] { nr, nc });
                    visited[paper[nr][nc]] = true;
                }
            }
        }
        System.out.println(result);
    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < R && nc < C;
    }
}
