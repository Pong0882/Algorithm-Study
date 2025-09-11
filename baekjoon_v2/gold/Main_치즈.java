package baekjoon_v2.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_치즈 {
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };
    static boolean[][] visited;
    static boolean[][] paper;
    static ArrayDeque<Integer[]> q = new ArrayDeque<>();
    static ArrayDeque<Integer[]> qq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new boolean[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    paper[i][j] = true;
                }
            }
        }

        q.add(new Integer[] { 0, 0 });
        visited[0][0] = true;
        int result = 0;
        int time = 0;

        while (true) {
            time++;
            while (!q.isEmpty()) {
                Integer[] tmp = q.poll();
                int r = tmp[0];
                int c = tmp[1];

                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (isOut(nr, nc)) {
                        continue;
                    }
                    if (visited[nr][nc]) {
                        continue;
                    }
                    if (paper[nr][nc]) {
                        qq.add(new Integer[] { nr, nc });
                    } else {
                        q.add(new Integer[] { nr, nc });
                    }
                    visited[nr][nc] = true;
                }
            }

            if (qq.isEmpty()) {
                break;
            }
            result = qq.size();
            for (int i = 0; i < result; i++) {
                q.add(qq.poll());
            }
        }

        sb.append(time - 1);
        sb.append("\n");
        sb.append(result);
        System.out.println(sb);
    }

    private static boolean isOut(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= M;
    }
}
