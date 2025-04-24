package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_틱택토 {
    static int[][] paper;
    static int x, o;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            char[] c = br.readLine().toCharArray();
            if (c[0] == 'e') {
                break;
            }

            paper = new int[3][3];
            x = 0;
            o = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    switch (c[i * 3 + j]) {
                        case 'X':
                            paper[i][j] = 10;
                            x++;
                            break;
                        case 'O':
                            paper[i][j] = 1;
                            o++;
                            break;
                        case '.':
                            paper[i][j] = 0;
                            break;
                        default:
                            break;
                    }
                }
            }
            // for (int i = 0; i < 3; i++) {
            // System.out.println(Arrays.toString(paper[i]));
            // }
            boolean owin = check(1);
            boolean xwin = check(10);
            if (owin && xwin) {
                sb.append("invalid").append("\n");
            } else if (owin && !xwin) {
                sb.append(o == x ? "valid" : "invalid").append("\n");
            } else if (xwin && !owin) {
                sb.append(o + 1 == x ? "valid" : "invalid").append("\n");
            } else if (x + o == 9) {
                sb.append(o + 1 == x ? "valid" : "invalid").append("\n");
            } else {
                sb.append("invalid").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean check(int hash) {
        int sol = hash * 3;
        int diag = 0;
        int rdiag = 0;
        for (int i = 0; i < 3; i++) {
            int r = 0;
            int c = 0;
            diag += paper[i][i];
            rdiag += paper[2 - i][i];
            for (int j = 0; j < 3; j++) {
                r += paper[j][i];
                c += paper[i][j];
            }
            // System.out.println(r + " " + c + " " + diag + " " + rdiag + " ");
            if (r == sol || c == sol || diag == sol || rdiag == sol) {
                return true;
            }
        }
        return false;
    }
}
