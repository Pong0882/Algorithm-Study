package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_카드게임 {
    static int win, lose;
    static int[] A, B;
    static StringBuilder sb = new StringBuilder();
    static int[] select;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int TC = 1; TC <= T; TC++) {
            win = 0;
            lose = 0;
            List<Integer> tmp = new ArrayList<>();
            A = new int[9];
            B = new int[9];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                A[i] = Integer.parseInt(st.nextToken());
                tmp.add(A[i]);
            }
            int tmpc = 0;
            for (int i = 0; i < 18; i++) {
                if (!tmp.contains(i + 1))
                    B[tmpc++] = i + 1;
            }
            select = new int[9];
            visited = new boolean[9];
            perm(0);

            // System.out.println(Arrays.toString(A));
            // System.out.println(Arrays.toString(B));

            sb.append("#").append(TC).append(" ").append(win).append(" ").append(lose).append("\n");
        }
        System.out.println(sb);
    }

    private static void perm(int cnt) {
        // TODO Auto-generated method stub
        if (cnt == 9) {
            check();
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (visited[i]) {
                continue;
            }
            select[cnt] = B[i];
            visited[i] = true;
            perm(cnt + 1);
            visited[i] = false;
        }
    }

    private static void check() {
        int pointA = 0;
        int pointB = 0;
        for (int i = 0; i < 9; i++) {
            if (A[i] > select[i]) {
                pointA += A[i] + select[i];
            }
            if (A[i] < select[i]) {
                pointB += A[i] + select[i];
            }
        }
        if (pointA > pointB) {
            win++;
        }
        if (pointA < pointB) {
            lose++;
        }
    }
}
