package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_미로탐색 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int A, B, N, M, result;
    private static int[][] paper;
    private static int[][] val;

    private static int[] dx = { 1, 0, -1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };

    // 아래 -> 오른 -> 위 -> 왼쪽 순서대로 탐색
    // 이동할떄 이동 value 값을 지정해주고 만약 기존 value 값보다 크다면 가지치기
    // 재귀 할땐 갈수 있는 칸 일때만 들어가줌
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        val = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                paper[i][j] = c[j] - '0';
                val[i][j] = N * M;
            }
        }

        maze(0, 0, 0);
        System.out.println(val[N - 1][M - 1] + 1);
        // for (int i = 0; i < N; i++) {
        // for (int j = 0; j < M; j++) {
        // System.out.print(val[i][j] + " ");
        // }
        // System.out.println("");
        // }
    }

    private static void maze(int x, int y, int cnt) {
        if (val[x][y] <= cnt)
            return;

        val[x][y] = cnt++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }
            if (paper[nx][ny] == 0)
                continue;
            maze(nx, ny, cnt);

        }
    }
}
