package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_주난의난 {
    static int R, C;
    static boolean[][] paper;
    static int[] start = new int[2];
    static int[] end = new int[2];
    static boolean[][] visited;
    static int[] dr = { 0, 0, -1, 1 };
    static int[] dc = { 1, -1, 0, 0 };
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        start[0] = Integer.parseInt(st.nextToken()) - 1;
        start[1] = Integer.parseInt(st.nextToken()) - 1;
        end[0] = Integer.parseInt(st.nextToken()) - 1;
        end[1] = Integer.parseInt(st.nextToken()) - 1;

        paper = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (c[j] == '1') {
                    paper[i][j] = true;
                }
            }
        }
        // System.out.println();
        // for (int i = 0; i < R; i++) {
        // for (int j = 0; j < C; j++) {
        // if (paper[i][j]) {
        // System.out.print(1);
        // } else {
        // System.out.print(0);
        // }
        // }
        // System.out.println();
        // System.out.println(Arrays.toString(paper[i]));
        // }
        // System.out.println();

        jump();
        System.out.println(result);
    }

    private static void jump() {
        while (true) {
            result++;
            Queue<Integer[]> queue = new ArrayDeque<>();
            Queue<Integer[]> boom = new ArrayDeque<>();
            queue.add(new Integer[] { start[0], start[1] });
            visited = new boolean[R][C];
            visited[start[0]][start[1]] = true;
            // for (int i = 0; i < R; i++) {
            // System.out.println(Arrays.toString(visited[i]));
            // }
            while (!queue.isEmpty()) {
                Integer[] tmp = queue.poll();
                int r = tmp[0];
                int c = tmp[1];
                // System.out.println(r + " " + c);
                // System.out.println("here");
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (!check(nr, nc)) {
                        continue;
                    }
                    if (visited[nr][nc]) {
                        continue;
                    }
                    if (nr == end[0] && nc == end[1]) {
                        return;
                    }
                    if (paper[nr][nc] == true) {
                        visited[nr][nc] = true;
                        boom.add(new Integer[] { nr, nc });
                    } else if (!visited[nr][nc]) {
                        // System.out.println(nr + " " + nc);
                        visited[nr][nc] = true;
                        queue.add(new Integer[] { nr, nc });
                    }
                }
            }
            while (!boom.isEmpty()) {
                Integer[] tmp = boom.poll();
                int r = tmp[0];
                int c = tmp[1];
                paper[r][c] = false;
            }
        }

        // System.out.println();
        // for (int i = 0; i < R; i++) {
        // for (int j = 0; j < C; j++) {
        // if (paper[i][j]) {
        // System.out.print(1);
        // } else {
        // System.out.print(0);
        // }
        // }
        // System.out.println();
        // // System.out.println(Arrays.toString(paper[i]));
        // }
    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < R && nc < C;
    }
}
