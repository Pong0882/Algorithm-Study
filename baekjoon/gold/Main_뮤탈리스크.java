package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_뮤탈리스크 {
    static int N;
    static int[][] paper;
    static int[] d3 = { 9, 9, 3, 3, 1, 1 };
    static int[] d2 = { 3, 1, 1, 9, 3, 9 };
    static int[] d1 = { 1, 3, 9, 1, 9, 3 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        paper = new int[3][60];
        for (int i = 0; i < 3; i++) {
            if (st.hasMoreTokens()) {
            }
            // paper[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(Arrays.toString(paper));
        ArrayDeque<Integer[]> que = new ArrayDeque<>();
        // que.add(new Integer[] { paper[0], paper[1], paper[2] });
        while (!que.isEmpty()) {
            Integer[] tmp = que.poll();
            int one = tmp[0];
            int two = tmp[1];
            int three = tmp[2];
            for (int i = 0; i < 3; i++) {
                int none = one - d1[i];
                int ntwo = two - d2[i];
                int nthree = three - d3[i];

            }
        }
    }
}
