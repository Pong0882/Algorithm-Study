package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_사다리조작 {
    static int N, M, H;
    static boolean[][] radder;
    static int[] select;
    static int result;
    static boolean good;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        radder = new boolean[H + 1][N + 1];
        select = new int[3];
        result = 3;
        Arrays.fill(select, -1);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            radder[r][c] = true;
        }
        // for (int j = 0; j < H + 1; j++) {
        // System.out.println(Arrays.toString(radder[j]));
        // }
        combi(0, 0);
        // System.out.println(result);
        // System.out.println(good);
        System.out.println(good ? result : -1);
    }

    private static void combi(int cnt, int start) {
        if (cnt <= 3) {
            // System.out.println(Arrays.toString(select));
            // for (int j = 0; j < H + 1; j++) {
            // System.out.println(Arrays.toString(radder[j]));
            // }
            // System.out.println();
            check(cnt);
        }
        if (cnt == 3) {
            return;
        }
        for (int i = start; i < (N - 1) * (H); i++) {
            int r = i / (N - 1) + 1;
            int c = i % (N - 1) + 1;
            if (radder[r][c] || radder[r][c - 1] || radder[r][c + 1]) {
                continue;
            }
            // System.out.println(i + " " + r + " " + c);
            select[cnt] = i;
            radder[r][c] = true;
            combi(cnt + 1, i + 1);
            select[cnt] = -1;
            radder[r][c] = false;
        }
    }

    private static void check(int cnt) {
        for (int i = 0; i < N; i++) {
            int line = i;
            for (int j = 0; j < H + 1; j++) {
                if (radder[j][line]) {
                    line--;
                } else if (radder[j][line + 1]) {
                    line++;
                }
            }
            if (line != i) {
                return;
            }
        }
        result = Math.min(cnt, result);
        good = true;
    }
}
