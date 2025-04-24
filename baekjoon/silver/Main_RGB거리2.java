package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_RGB거리2 {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int tmpA = Math.min(dp[1], dp[2]) + Integer.parseInt(st.nextToken());
            int tmpB = Math.min(dp[0], dp[2]) + Integer.parseInt(st.nextToken());
            int tmpC = Math.min(dp[1], dp[0]) + Integer.parseInt(st.nextToken());
            dp[0] = tmpA;
            dp[1] = tmpB;
            dp[2] = tmpC;
        }
        System.out.println(Math.min(dp[0], Math.min(dp[1], dp[2])));
    }
}
