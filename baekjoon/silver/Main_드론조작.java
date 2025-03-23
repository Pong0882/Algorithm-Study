package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_드론조작 {
    static int N, K;
    static int[][] paper;
    static int[] dr = { 1, -1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };
    static int resultr, resultc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        paper = new int[1001][1001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = 500;
            int c = 500;
            c += Integer.parseInt(st.nextToken());
            r += Integer.parseInt(st.nextToken());

            // System.out.println(r + " " + c);
            paper[r][c] = -1;
        }
        resultc = 500;
        resultr = 500;
        char[] c = br.readLine().toCharArray();
        // System.out.println("Hello");
        for (int i = 0; i < c.length; i++) {
            char comm = c[i];
            // System.out.println(resultr + " " + resultr);
            // System.out.println(resultr + " " + resultc);
            switch (comm) {
                case 'U':
                    move(0);
                    break;
                case 'D':
                    move(1);
                    break;
                case 'R':
                    move(2);
                    break;
                case 'L':
                    move(3);
                    // System.out.println("Hello");
                    break;

                default:
                    break;
            }
        }
        resultr -= 500;
        resultc -= 500;

        System.out.println(resultc + " " + resultr);
    }

    private static void move(int m) {
        int r = resultr;
        int c = resultc;
        int nr = r + dr[m];
        int nc = c + dc[m];
        // System.out.println(nr + " " + nc + " Hello?");
        if (paper[nr][nc] != -1) {
            resultr = nr;
            resultc = nc;
        }
    }
}
