package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_구슬탈출2 {
    static int R, C;
    static int[][] paper;
    static int redr, redc;
    static int bluer, bluec;
    static int holer, holec;
    static int[] dr = { 1, -1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(brr.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        paper = new int[R][C];
        for (int i = 0; i < R; i++) {
            char[] ch = brr.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                switch (ch[j]) {
                    case '#':
                        paper[i][j] = -1;
                        break;
                    case 'R':
                        redr = i;
                        redc = j;
                        break;
                    case 'B':
                        bluer = i;
                        bluec = j;
                        break;
                    case 'O':
                        holer = i;
                        holec = j;
                        break;
                    default:
                        break;
                }
            }
        }
        ArrayDeque<Integer[]> q = new ArrayDeque<>();
        q.add(new Integer[] { redr, redc, bluer, bluec, 0 });

        while (!q.isEmpty()) {
            Integer[] tmp = q.poll();
            int rr = tmp[0];
            int rc = tmp[1];
            int br = tmp[2];
            int bc = tmp[3];
            int time = tmp[4];
            for (int i = 0; i < 4; i++) {
                int nrr = rr + dr[i];
                int nrc = rc + dc[i];
                int nbr = br + dr[i];
                int nbc = bc + dc[i];
            }
        }
    }

}
