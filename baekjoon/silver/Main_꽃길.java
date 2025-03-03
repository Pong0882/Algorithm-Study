package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_꽃길 {
    static int N;
    static int[][] paper;
    static int[] select;
    static boolean[][] visited;
    static int result = Integer.MAX_VALUE;
    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        select = new int[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi(0, 0);
        System.out.println(result);
    }

    private static void combi(int cnt, int start) {
        if (cnt == 3) {
            // System.out.println(Arrays.toString(select));
            checkValue();
            return;
        }

        for (int i = start; i < N * N; i++) {
            if (outline(i))
                continue;
            select[cnt] = i;
            combi(cnt + 1, i + 2); // 다되면 i+2도 고려해보자
        }
    }

    private static void checkValue() {
        visited = new boolean[N][N];
        int tmpResult = 0;
        for (int i = 0; i < 3; i++) {
            int tmp = select[i];
            int r = tmp / N;
            int c = tmp % N;
            visited[r][c] = true;
            tmpResult += paper[r][c];
            for (int j = 0; j < 4; j++) {
                int nr = r + dr[j];
                int nc = c + dc[j];
                if (visited[nr][nc] == true) {
                    return;
                }
                visited[nr][nc] = true;
                tmpResult += paper[nr][nc];
            }
        }
        result = Math.min(tmpResult, result);
    }

    private static boolean outline(int n) {
        return n < N || n % N == 0 || n % N == N - 1 || n / N == N - 1;
    }
}
