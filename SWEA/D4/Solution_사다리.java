package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_사다리 {
    static List<Integer> line;
    static int[][] paper;
    static int N = 100;
    static int result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int TC = 1; TC <= 10; TC++) {
            int T = Integer.parseInt(br.readLine());
            paper = new int[N][N + 2];
            line = new ArrayList<>();
            result = N;
            for (int i = 0; i < N; i++) {// 입력받기
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < N + 1; j++) {
                    paper[i][j] = Integer.parseInt(st.nextToken());

                }
            }
            for (int i = 0; i < N + 2; i++) {
                if (paper[0][i] == 1) {
                    line.add(i);
                }
            }
            // for (int i = 0; i < line.size(); i++) { // 체크
            // System.out.print(line.get(i) + " ");

            // }
            int tmp = 100000;
            int index = 0;
            for (int i = 0; i < line.size(); i++) {
                result = N;
                move(line.get(i), i);
                if (result < tmp) {
                    index = line.get(i);
                }
                tmp = Math.min(result, tmp);
            }
            sb.append("#").append(T).append(" ").append(index).append("\n");
            // for (int start : line) {
            // move(start);
            // }
            /////////////////////////////
        }
        System.out.println(sb);
    }

    private static void move(Integer start, int index) {
        // int r = 0;
        int c = start;
        int l = index;
        for (int i = 0; i < N; i++) {
            int tmp = line.get(l);
            int left = tmp - 1;
            int right = tmp + 1;
            if (paper[i][left] == 1) {
                result += line.get(l) - line.get(l - 1);
                l--;
            }
            if (paper[i][right] == 1) {
                result += line.get(l + 1) - line.get(l);
                l++;
            }
        }
    }
}