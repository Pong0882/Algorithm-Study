package SWEA.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_최적경로 {
    static StringBuilder sb = new StringBuilder();
    static int[] select;
    static boolean[] visited;
    static int[][] paper;
    static int result = Integer.MAX_VALUE;
    static ArrayList<Integer[]> position;
    static int N;
    static int startr, startc;
    static int endr, endc;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int TC = 1; TC <= T; TC++) {
            result = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            paper = new int[N][N];
            visited = new boolean[N];
            select = new int[N];
            position = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            startr = Integer.parseInt(st.nextToken());
            startc = Integer.parseInt(st.nextToken());
            endr = Integer.parseInt(st.nextToken());
            endc = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                position.add(new Integer[] { r, c });
            }
            for (int i = 0; i < N; i++) {
                Integer[] tmp = position.get(i);
                int r = tmp[0];
                int c = tmp[1];
                for (int j = 0; j < N; j++) {
                    if (i == j) {
                        paper[i][j] = -1;
                        continue;
                    }
                    Integer[] tmp2 = position.get(j);
                    int rr = tmp2[0];
                    int cc = tmp2[1];
                    paper[i][j] = Math.abs(r - rr) + Math.abs(c - cc);
                }
            }
            // for (int i = 0; i < N; i++) {
            // System.out.println(Arrays.toString(paper[i]));
            // }
            perm(0);
            sb.append("#").append(TC).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void perm(int cnt) {
        if (cnt == N) {
            // System.out.println(Arrays.toString(select));
            oper();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            select[cnt] = i;
            visited[i] = true;
            perm(cnt + 1);
            visited[i] = false;
        }
    }

    private static void oper() {
        int tmp = Math.abs(startr - position.get(select[0])[0]) + Math.abs(startc - position.get(select[0])[1]);
        int row = select[0];
        for (int i = 1; i < N; i++) {
            tmp += paper[row][select[i]];
            row = select[i];
        }
        tmp += Math.abs(endr - position.get(select[N - 1])[0]) + Math.abs(endc - position.get(select[N - 1])[1]);
        result = Math.min(tmp, result);
        // System.out.println(tmp);
    }
}
