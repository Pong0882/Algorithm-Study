package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_불 {
    static int[][] paper;
    static int result;
    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };
    static int R, C;
    static int manr, manc;
    static boolean clear;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int TC = 0; TC < T; TC++) {
            clear = false;
            result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            paper = new int[R][C];

            for (int i = 0; i < R; i++) {
                char[] c = br.readLine().toCharArray();
                for (int j = 0; j < C; j++) {
                    if (c[j] == '#') {
                        paper[i][j] = -10000;
                    } else if (c[j] == '@') {
                        paper[i][j] = 1;
                        manr = i;
                        manc = j;
                    } else if (c[j] == '*') {
                        paper[i][j] = -1;
                    } else {
                        paper[i][j] = 0;
                    }
                }
            }

            gogo();
            // for (int i = 0; i < R; i++) {
            // System.out.println(Arrays.toString(paper[i]));
            // }
            sb.append(clear ? result : "IMPOSSIBLE").append("\n");
        }
        System.out.println(sb);
    }

    private static void gogo() throws IOException {
        Queue<Integer[]> man = new ArrayDeque<>(); // 사람
        Queue<Integer[]> fire = new ArrayDeque<>(); // 불!
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (paper[i][j] == result + 1) {
                    // 사람 한칸씩 이동해서 숫자 싸
                    man.add(new Integer[] { i, j }); // 사람 넣어!
                }
                if (paper[i][j] == -result - 1) {
                    fire.add(new Integer[] { i, j }); // 불 넣어!
                }
            }
        }
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // String str = br.readLine();
            result++;
            Queue<Integer[]> mantmp = new ArrayDeque<>();
            Queue<Integer[]> firetmp = new ArrayDeque<>();
            // System.out.println(man.size());
            while (!fire.isEmpty()) {
                Integer[] tmp = fire.poll();
                int firer = tmp[0];
                int firec = tmp[1];
                for (int i = 0; i < 4; i++) {
                    int nfirer = firer + dr[i];
                    int nfirec = firec + dc[i];
                    if (!check(nfirer, nfirec)) {
                        continue;
                    }
                    if (paper[nfirer][nfirec] == -10000) {
                        continue;
                    }
                    if (paper[nfirer][nfirec] == 0) {
                        paper[nfirer][nfirec] = -1;
                        firetmp.add(new Integer[] { nfirer, nfirec });
                    }
                }
            }
            while (!firetmp.isEmpty()) {
                fire.add(firetmp.poll());
            }
            while (!man.isEmpty()) { // 사람 숫자 쓰기
                Integer[] tmp = man.poll();
                manr = tmp[0];
                manc = tmp[1];
                if (endGame()) { // 게임 끝내
                    clear = true;
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    int nmanr = manr + dr[i];
                    int nmanc = manc + dc[i];

                    if (!check(nmanr, nmanc)) {
                        continue;
                    }
                    if (paper[nmanr][nmanc] == 0) {
                        paper[nmanr][nmanc] = result + 1;
                        mantmp.add(new Integer[] { nmanr, nmanc });
                    }
                }
            }
            if (mantmp.isEmpty()) {
                return;
            }
            // System.out.println(mantmp.size());
            // System.out.println(firetmp.size());
            while (!mantmp.isEmpty()) {
                man.add(mantmp.poll());
            }
            // for (int i = 0; i < R; i++) {
            // System.out.println(Arrays.toString(paper[i]));
            // }
        }
    }

    private static boolean check(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    private static boolean endGame() {
        return manr == 0 || manr == R - 1 || manc == 0 || manc == C - 1;
    }
}
