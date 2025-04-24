package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_RGB거리 {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int tmp1 = a + Math.min(dp[1], dp[2]);
            int tmp2 = b + Math.min(dp[0], dp[2]);
            int tmp3 = c + Math.min(dp[0], dp[1]);
            dp[0] = tmp1;
            dp[1] = tmp2;
            dp[2] = tmp3;
        }
        System.out.println(Math.min(dp[0], Math.min(dp[1], dp[2])));
    }
}
