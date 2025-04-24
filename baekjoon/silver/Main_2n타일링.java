package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2n타일링 {
    static int result;
    static int[] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 2];
        dp[1] = 1;
        dp[2] = 3;
        result = gogo(N);
        System.out.println(result);
    }

    private static int gogo(int n) {
        // System.out.println(Arrays.toString(dp));
        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = (gogo(n - 1) + 2 * gogo(n - 2)) % 10007;
    }
}
