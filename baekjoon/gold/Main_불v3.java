package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_불v3 {
    static int w, h;
    static char[][] map;
    static int[][] fireTime, manTime;
    static int[] dr = { 1, -1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            fireTime = new int[h][w];
            manTime = new int[h][w];

            for (int i = 0; i < h; i++) {
                Arrays.fill(fireTime[i], Integer.MAX_VALUE);
                Arrays.fill(manTime[i], -1);
            }

            Queue<int[]> fireQueue = new ArrayDeque<>();
            Queue<int[]> manQueue = new ArrayDeque<>();

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '*') {
                        fireTime[i][j] = 0;
                        fireQueue.offer(new int[] { i, j });
                    }
                    if (map[i][j] == '@') {
                        manTime[i][j] = 0;
                        manQueue.offer(new int[] { i, j });
                    }
                }
            }

            while (!fireQueue.isEmpty()) {
                int[] cur = fireQueue.poll();
                int r = cur[0], c = cur[1];
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i], nc = c + dc[i];
                    if (nr < 0 || nc < 0 || nr >= h || nc >= w)
                        continue;
                    if (map[nr][nc] == '#')
                        continue;
                    if (fireTime[nr][nc] <= fireTime[r][c] + 1)
                        continue;
                    fireTime[nr][nc] = fireTime[r][c] + 1;
                    fireQueue.offer(new int[] { nr, nc });
                }
            }

            int answer = -1;
            while (!manQueue.isEmpty()) {
                int[] cur = manQueue.poll();
                int r = cur[0], c = cur[1];
                if (r == 0 || c == 0 || r == h - 1 || c == w - 1) {
                    answer = manTime[r][c] + 1;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i], nc = c + dc[i];
                    if (nr < 0 || nc < 0 || nr >= h || nc >= w)
                        continue;
                    if (map[nr][nc] == '#')
                        continue;
                    if (manTime[nr][nc] != -1)
                        continue;
                    if (manTime[r][c] + 1 >= fireTime[nr][nc])
                        continue;
                    manTime[nr][nc] = manTime[r][c] + 1;
                    manQueue.offer(new int[] { nr, nc });
                }
            }

            sb.append(answer == -1 ? "IMPOSSIBLE" : answer).append("\n");
        }
        System.out.print(sb);
    }
}
