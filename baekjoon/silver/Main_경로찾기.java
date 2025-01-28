package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_경로찾기 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int A, B, N, M;
    private static int[][] paper;
    private static int[][] result;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // N = Integer.parseInt(br.readLine());

        // paper = new int[N];
        // st = new StringTokenizer(br.readLine());
        // for (int i = 0; i < N; i++) {
        // paper[i] = Integer.parseInt(st.nextToken());
        // }

        N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        result = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            Path(i, i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void Path(int x, int point) {
        if (visited[point]) {
            return;
        }

        for (int j = 0; j < N; j++) {
            if (paper[point][j] == 1) {
                result[x][j] = 1;
                // System.out.println(x + " " + j);
                visited[point] = true;
                Path(x, j);
                visited[point] = false;
            }
        }
    }
}