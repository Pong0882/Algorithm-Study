package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_햄버거다이어트dp {
    private static int N, L;
    // private static int[] select;
    private static int[][] material;
    private static int resultMaxValue;
    private static boolean[] select;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int Tcase = 1; Tcase <= T; Tcase++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            int paper[] = new int[L + 1];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int calo = Integer.parseInt(st.nextToken());
                // System.out.println(Arrays.toString(paper));
                for (int j = L; j >= calo; j--) {
                    paper[j] = Math.max(score + paper[j - calo], paper[j]);
                }
            }
            sb.append("#").append(Tcase).append(" ").append(paper[L]).append("\n");
        }
        System.out.println(sb);

    }
}
