package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_적록색약 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static char[][] paper, paper2;
    private static boolean[][] visited, visitedBlind;

    private static int[] dx = { 0, 0, 1, -1 };
    private static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        paper = new char[N][N];
        paper2 = new char[N][N];
        visited = new boolean[N][N];
        visitedBlind = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                paper[i][j] = s.charAt(j);
                paper2[i][j] = (paper[i][j] == 'G') ? 'R' : paper[i][j];
            }
        }

        int normalCount = 0, blindCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs1(i, j, paper[i][j]);
                    normalCount++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedBlind[i][j]) {
                    dfs2(i, j, paper2[i][j]);
                    blindCount++;
                }
            }
        }

        System.out.println(normalCount + " " + blindCount);
    }

    private static void dfs1(int x, int y, int color) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visited[nx][ny] && paper[nx][ny] == color) {
                    dfs1(nx, ny, color);
                }
            }
        }
    }

    private static void dfs2(int x, int y, int color) {
        visitedBlind[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visitedBlind[nx][ny] && paper2[nx][ny] == color) {
                    dfs2(nx, ny, color);
                }
            }
        }
    }
}