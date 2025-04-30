package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_창고다각형 {
    static int N;
    static int result;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        paper = new int[N][2];
        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            paper[i][0] = Integer.parseInt(st.nextToken());
            paper[i][1] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, paper[i][1]);
        }

        Arrays.sort(paper, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int x = paper[0][0];
        int y = paper[0][1];
        for (int i = 1; i < N; i++) {
            int nx = paper[i][0];
            int ny = paper[i][1];
            if (ny > y) {
                result += (nx - x) * y;
                x = nx;
                y = ny;
            }
            if (y == maxHeight)
                break;
        }

        x = paper[N - 1][0];
        y = paper[N - 1][1];
        for (int i = N - 2; i >= 0; i--) {
            int nx = paper[i][0];
            int ny = paper[i][1];
            if (ny > y) {
                result += (x - nx) * y;
                x = nx;
                y = ny;
            }
            if (y == maxHeight)
                break;
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (paper[i][1] == maxHeight) {
                left = Math.min(left, paper[i][0]);
                right = Math.max(right, paper[i][0]);
            }
        }

        result += (right - left + 1) * maxHeight;

        System.out.println(result);
    }
}
