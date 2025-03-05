package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.print.attribute.standard.PrintQuality;

public class Main_말되원v2 {
    static int S, R, C;

    static int[][] paper;
    static int result = -1;
    static int[] dr = { 0, 0, 1, -1, -1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] dc = { 1, -1, 0, 0, -2, -1, 1, 2, 2, 1, -1, -2 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        S = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        paper = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    paper[i][j] = -1;
                } else {
                    paper[i][j] = 1000000;
                }
            }
        }
        ArrayDeque<int[]> monkey = new ArrayDeque<>();
        // PriorityQueue<int[]> monkey = new PriorityQueue<>((a, b) -> b[3] - a[3]);
        monkey.add(new int[] { 0, 0, 0, S });

        while (!monkey.isEmpty()) {
            int[] tmp = monkey.poll();
            int r = tmp[0];
            int c = tmp[1];
            int t = tmp[2];
            int s = tmp[3];
            System.out.println(r + " " + c + " " + t + " " + s);
            if (r == R - 1 && c == C - 1) {
                result = t;
                break;
            }
            for (int i = 0; i < 12; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (!check(nr, nc)) {
                    continue;
                }
                if (t >= paper[nr][nc] || paper[nr][nc] == -1) {
                    continue;
                }

                if (i >= 4 && s > 0) { // 스킬 사용
                    monkey.add(new int[] { nr, nc, t + 1, s - 1 });
                    paper[nr][nc] = t + 1;
                }
                if (i < 4) { // 스킬 안사용
                    monkey.add(new int[] { nr, nc, t + 1, s });
                    paper[nr][nc] = t + 1;
                }

            }
        }
        for (int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(paper[i]));
        }
        System.out.println(result);
    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < R && nc < C;
    }
}
