package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_행복유치원 {
    static int N, K;
    // static int[] select;
    static int[] paper;
    static int[] dp;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        paper = new int[N];
        st = new StringTokenizer(br.readLine());
        paper[0] = Integer.parseInt(st.nextToken());
        dp = new int[N];
        for (int i = 1; i < N; i++) {
            paper[i] = Integer.parseInt(st.nextToken());
            dp[i] = paper[i] - paper[i - 1];
        }
        Arrays.sort(dp);
        // System.out.println(Arrays.toString(dp));
        for (int i = 0; i < dp.length - K + 1; i++) {
            result += dp[i];
        }
        System.out.println(result);
    }
}
