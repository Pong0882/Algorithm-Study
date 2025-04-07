import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[k + 1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;
        // System.out.println(Arrays.toString(dp));
        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());

            for (int j = coin; j < k + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        // System.out.println(Arrays.toString(dp));
        System.out.println(dp[k] == 100001 ? -1 : dp[k]);
    }
}
