package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

class block {
    public block(int time, int skill) {
        this.time = time;
        this.skill = skill;
    }

    int time, skill;
}

public class Main_말되원 {
    static int maxSkill;
    // static int[][][] paper;
    static block[][] paper;
    // static boolean[][] visited;
    static int R, C;
    static int[] dr = { 0, 0, 1, -1, -1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] dc = { 1, -1, 0, 0, -2, -1, 1, 2, 2, 1, -1, -2 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        maxSkill = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        paper = new block[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    paper[i][j] = new block(-1, -1);
                } else {
                    paper[i][j] = new block(10000, -1);
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(paper[i][j].skill + " " + paper[i][j].time + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(paper[i][j].skill + " ");
            }
            System.out.println();
        }
        ArrayDeque<Integer[]> money = new ArrayDeque<>();
        money.add(new Integer[] { 0, 0 });
        paper[0][0] = new block(0, maxSkill);
        int result = -1;
        while (!money.isEmpty()) {
            Integer[] tmp = money.poll();
            int r = tmp[0];
            int c = tmp[1];
            int t = paper[r][c].time;
            int s = paper[r][c].skill;
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
                if (paper[nr][nc].time == -1) {
                    continue;
                }
                int nt = paper[nr][nc].time;
                int ns = paper[nr][nc].skill;
                if (i >= 4 && s > 0) { // 스킬 사용
                    // 이게되나..?
                    if (nt >= t + 1 && ns <= s - 1) {
                        money.add(new Integer[] { nr, nc });
                        paper[nr][nc] = new block(t + 1, s - 1);
                        // System.out.println("helelo");
                    }
                }
                // 스킬 안사용
                if (nt >= t + 1) {
                    money.add(new Integer[] { nr, nc });
                    paper[nr][nc] = new block(t + 1, s);
                }

            }
        }
        System.out.println();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(paper[i][j].time + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(paper[i][j].skill + " ");
            }
            System.out.println();
        }
        System.out.println(result);
    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < R && nc < C;
    }
}
