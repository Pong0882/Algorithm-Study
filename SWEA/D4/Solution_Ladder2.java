package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_Ladder2 {
    static int[][] ladder;
    static int result;
    static int[] dr = { 1, 0, 0 };
    static int[] dc = { 0, -1, 1 };
    static int size = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        for (int TC = 1; TC <= T; TC++) { //////////////////
            ladder = new int[size][size];
            for (int i = 0; i < size; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < size; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < size; i++) {
                if (ladder[0][i] == 1) {
                    // 사다리를 타자
                    move(i);
                }
            }
            sb.append("#").append(TC).append(" ").append(result);
        }
    }

    private static void move(int start) {
        int r = 0;
        int c = start;
        int d = 0;
        while (r <= size) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 직진중일때
            if (d == 0) {
                // 왼쪽체크
                int left = nc - 1;
                if (left >= 0 && ladder[nr][left] == 1) {
                    d = 1;
                }
                // 오른쪽체크
                int right = nc + 1;
                if (right < size && ladder[nr][right] == 1) {
                    d = 2;
                }
            } else {
                if (!check(nc) || ladder[nr][nc] == 0) {// 좌우체크
                    d = 0;
                }
            }
        }
    }

    private static boolean check(int nc) {
        return nc >= 0 && nc < size;
    }

}
