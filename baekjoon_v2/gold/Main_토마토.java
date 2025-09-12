package baekjoon_v2.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_토마토 {
    static int N, M, H;
    static int[][][] paper;
    static int dr[] = { 1, -1, 0, 0, 0, 0 };
    static int dc[] = { 0, 0, 1, -1, 0, 0 };
    static int dh[] = { 0, 0, 0, 0, 1, -1 };

    static int blank;
    static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        paper = new int[H][N][M];

        ArrayDeque<Integer[]> q = new ArrayDeque<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    paper[h][n][m] = tmp;
                    if (tmp == 1)
                        q.add(new Integer[] { h, n, m });
                    else if (tmp == 0)
                        blank++;
                }
            }
        }

        if (blank == 0) {
            System.out.println(0);
            return;
        }

        time = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            for (int s = 0; s < size; s++) {
                Integer[] cur = q.poll();

                int h = cur[0];
                int r = cur[1];
                int c = cur[2];

                for (int i = 0; i < 6; i++) {
                    int nh = h + dh[i];
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (isOut(nr, nc, nh))
                        continue;

                    if (paper[nh][nr][nc] == 0) {
                        q.add(new Integer[] { nh, nr, nc });
                        blank--;
                        paper[nh][nr][nc] = 1;
                    }
                }
            }
        }

        System.out.println(blank == 0 ? time : -1);
    }

    private static boolean isOut(int nr, int nc, int nh) {
        return nr < 0 || nr >= N || nc < 0 || nc >= M || nh < 0 || nh >= H;
    }
}
