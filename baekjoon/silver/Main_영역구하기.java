package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_영역구하기 {
    static int N, M, R;

    static boolean[][] paper;
    static List<Integer> result = new ArrayList<>();
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        paper = new boolean[N][M];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int xx = Integer.parseInt(st.nextToken());
            int yy = Integer.parseInt(st.nextToken());
            for (int j = x; j < xx; j++) {
                for (int j2 = y; j2 < yy; j2++) {
                    paper[j][j2] = true;

                }
            }
        }
        // for (int i = 0; i < N; i++) {
        // System.out.println(Arrays.toString(paper[i]));
        // }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (paper[i][j]) {
                    continue;
                }
                int cnt = 1;
                Queue<Integer[]> queue = new ArrayDeque<>();
                queue.add(new Integer[] { i, j });
                paper[i][j] = true;
                while (!queue.isEmpty()) {
                    Integer[] tmp = queue.poll();
                    int r = tmp[0];
                    int c = tmp[1];
                    for (int k = 0; k < 4; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        if (!check(nr, nc)) {
                            continue;
                        }
                        if (paper[nr][nc] == true) {
                            continue;
                        }

                        queue.add(new Integer[] { nr, nc });
                        paper[nr][nc] = true;
                        cnt++;
                    }
                }
                result.add(cnt);
            }
        }
        System.out.println(result.size());

        Collections.sort(result);
        for (int n : result) {
            System.out.print(n + " ");
        }
    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < M;
    }
}
