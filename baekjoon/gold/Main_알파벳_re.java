package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_알파벳_re {
    static int R, C;
    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };
    static int[][] paper;
    static boolean[] visited;
    static int[][] note;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        paper = new int[R][C];
        visited = new boolean[26];
        note = new int[R][C];
        for (int i = 0; i < R; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                paper[i][j] = c[j] - 'A';
            }
        }
        visited[paper[0][0]] = true;

        DFS(0, 0, 1);
        // for (int i = 0; i < R; i++) {
        // System.out.println(Arrays.toString(note[i]));
        // }

        // /////////////////
        // ArrayDeque<Integer[]> q = new ArrayDeque<>();
        // q.add(new Integer[] { 0, 0 });
        // visited[paper[0][0]] = true;
        // int result = 0;
        // while (!q.isEmpty()) {
        // result++;
        // Integer[] tmp = q.poll();
        // int r = tmp[0];
        // int c = tmp[1];
        // for (int i = 0; i < 4; i++) {
        // int nr = r + dr[i];
        // int nc = c + dc[i];
        // if (!check(nr, nc))
        // continue;

        // if (!visited[paper[nr][nc]]) {
        // q.add(new Integer[] { nr, nc });
        // visited[paper[nr][nc]] = true;
        // }
        // }
        // }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result = Math.max(result, note[i][j]);
            }
        }
        System.out.println(result);
    }

    private static void DFS(int r, int c, int cnt) {

        note[r][c] = Math.max(note[r][c], cnt);
        // System.out.println(r + " " + c);
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!check(nr, nc))
                continue;
            if (!visited[paper[nr][nc]]) {
                visited[paper[nr][nc]] = true;
                DFS(nr, nc, cnt + 1);
                visited[paper[nr][nc]] = false;
            }
        }
    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < R && nc < C;
    }
}
