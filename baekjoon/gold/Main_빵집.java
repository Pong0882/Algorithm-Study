package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_빵집 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int R, C, result;
    private static int[][] paper;
    private static final int[] dx = { -1, 0, 1 };
    private static final int[] dy = { 1, 1, 1 };

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        paper = new int[R][C];

        for (int i = 0; i < R; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (c[j] == 'x') {
                    paper[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            if (DFS(i, 0)) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static boolean DFS(int x, int y) {
        if (y == C - 1) {
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C && paper[nx][ny] == 0) {
                paper[nx][ny] = 1;
                if (DFS(nx, ny)) {
                    return true;
                }
            }
        }

        return false;
    }
}