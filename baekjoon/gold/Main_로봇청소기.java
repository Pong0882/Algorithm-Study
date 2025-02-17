package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_로봇청소기 {
    private static int N, M;
    private static int d;
    private static int[][] paper;
    private static int robotr, robotc;
    private static int[] dr = { -1, 0, 1, 0 };
    private static int[] dc = { 0, 1, 0, -1 };
    private static int result;
    private static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        robotr = Integer.parseInt(st.nextToken());
        robotc = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean();
        System.out.println(result);
    }

    private static void clean() {
        while (true) {
            if (paper[robotr][robotc] == 0) {
                paper[robotr][robotc] = 1;
                result++;
                System.out.println(result + " " + robotr + " " + robotc);
            }
            check = false;
            for (int i = 0; i < 4; i++) {
                int nr = robotr + dr[i];
                int nc = robotc + dc[i];
                if (!check(nr, nc)) {
                    continue;
                }
                if (paper[nr][nc] == 1) {
                    check = true; // 깨끗한거있니?
                }
            }
            if (check == true) { // 꺠끗한거 없으면
                int move = (d + 2) % 4;
                int nr = robotr + dr[move];
                int nc = robotc + dc[move];
                if (check(nr, nc)) {
                    robotr = nr;
                    robotc = nc;
                } else {
                    return;
                }
            } else { // 3번조건 청소 안된거 잇으면
                for (int i = 0; i < 4; i++) {
                    d = (d + 3) % 4;
                    int nr = robotr + dr[d];
                    int nc = robotc + dc[d];
                    if (!check(nr, nc)) {
                        continue;
                    }
                    if (paper[nr][nc] == 1) {
                        continue;
                    } else {
                        robotr = nr;
                        robotc = nc;
                        break;
                    }
                }
            }
        }
    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < M;
    }
}
