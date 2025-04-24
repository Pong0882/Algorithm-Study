package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_톱니바퀴 {
    static int[][] ring;
    static int result;
    static int[][] position;
    static int N, spin;
    static int[] point = { 1, 2, 4, 8 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ring = new int[4][8];
        position = new int[4][2];

        for (int i = 0; i < 4; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                ring[i][j] = c[j] - '0';
            }
            position[i][0] = 6;
            position[i][1] = 2;
        }
        int re = Integer.parseInt(br.readLine());
        for (int i = 0; i < re; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            spin = Integer.parseInt(st.nextToken());

            if (N == 3) {
                boolean a = false;
                boolean b = false;
                boolean c = false;
                if (position[0][1] == position[1][0]) {
                    a = true;
                }
                if (position[1][1] == position[2][0]) {
                    b = true;
                }
                if (position[2][1] == position[3][0]) {
                    c = true;
                }
                if (b) {
                    if (a) {
                        position[0][0] = (position[0][0] + 8 + spin) % 8;
                        position[0][1] = (position[0][1] + 8 + spin) % 8;
                    }
                    position[1][0] = (position[1][0] + 8 - spin) % 8;
                    position[1][1] = (position[1][1] + 8 - spin) % 8;
                }
                if (c) {
                    position[3][0] = (position[3][0] + 8 - spin) % 8;
                    position[3][1] = (position[3][1] + 8 - spin) % 8;
                }
                position[2][0] = (position[2][0] + 8 + spin) % 8;
                position[2][1] = (position[2][1] + 8 + spin) % 8;
            }
            if (N == 1) {
                boolean a = false;
                boolean b = false;
                boolean c = false;
                if (position[0][1] == position[1][0]) {
                    a = true;
                }
                if (position[1][1] == position[2][0]) {
                    b = true;
                }
                if (position[2][1] == position[3][0]) {
                    c = true;
                }
                if (a) {
                    position[1][0] = (position[1][0] + 8 - spin) % 8;
                    position[1][1] = (position[1][1] + 8 - spin) % 8;
                    if (b) {
                        position[2][0] = (position[2][0] + 8 + spin) % 8;
                        position[2][1] = (position[2][1] + 8 + spin) % 8;
                        if (c) {
                            position[3][0] = (position[3][0] + 8 - spin) % 8;
                            position[3][1] = (position[3][1] + 8 - spin) % 8;
                        }
                    }
                }
                position[0][0] = (position[0][0] + 8 + spin) % 8;
                position[0][1] = (position[0][1] + 8 + spin) % 8;
            }
            for (int j = 0; j < 4; j++) {
                System.out.println(Arrays.toString(ring[j]));
            }
        }
        for (int i = 0; i < 4; i++) {
            int head = (position[i][0] + 2) % 8;
            if (ring[i][head] == 1) {
                result += point[i];
            }
        }
        System.out.println(result);
    }
}
