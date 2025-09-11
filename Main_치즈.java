package baekjoon_v2.gold;

import java.io.*;
import java.util.*;

public class Main_치즈 {
    static int N, M;
    static int[][] map;
    static final int[] dr = { 0, 0, 1, -1 };
    static final int[] dc = { 1, -1, 0, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int lastMelt = 0;

        while (true) {
            boolean[][] visited = new boolean[N][M];
            ArrayDeque<int[]> q = new ArrayDeque<>();
            ArrayList<int[]> toMelt = new ArrayList<>();

            // 외부 공기에서 시작
            q.add(new int[] { 0, 0 });
            visited[0][0] = true;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];

                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                        continue;
                    if (visited[nr][nc])
                        continue;

                    visited[nr][nc] = true;

                    if (map[nr][nc] == 1) {
                        // 인접 치즈는 이번 라운드에 녹음 대상으로만 표시
                        toMelt.add(new int[] { nr, nc });
                    } else {
                        // 공기는 계속 확장
                        q.add(new int[] { nr, nc });
                    }
                }
            }

            if (toMelt.isEmpty()) {
                // 더 이상 녹일 치즈 없음
                System.out.println(time);
                System.out.println(lastMelt);
                return;
            }

            // 이번 라운드에 치즈 녹이기
            lastMelt = toMelt.size();
            for (int[] p : toMelt) {
                map[p[0]][p[1]] = 0;
            }
            time++;
        }
    }
}
