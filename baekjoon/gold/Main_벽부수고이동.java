package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_벽부수고이동 {
    private static int N, M;
    private static int[][] paper;
    private static int[] dx = { 0, 0, 1, -1 };
    private static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] a = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                paper[i][j] = a[j] - '0';
            }
        }

        System.out.println(bfs());

        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(paper[i]));
        }
    }

    private static int bfs() {
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[] { 0, 0, 2, 1 }); // x, y, cnt, life
        paper[0][0] = 2;
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            int life = now[3]; // 목숨 까여

            if (life == 0) {
                return -1;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!check(nx, ny)) {
                    continue;
                }
                if (paper[nx][ny] >= paper[x][y]) {
                    continue;
                }
                if (paper[nx][ny] == 1) {
                    if (life == 0) {
                        continue;
                    }
                    if (paper[nx][ny] > 1 && cnt + 1 < paper[nx][ny]) { // 누군가 갔지만 느려도 들어가
                        life--;

                    }
                }

            }
        }
        return 1;
    }

    private static boolean check(int x, int y) {
        return x >= 0 && y >= 00 && x < N && y < M;
    }
}
