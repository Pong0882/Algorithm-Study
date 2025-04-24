import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물건 수
        int K = Integer.parseInt(st.nextToken()); // 최대 무게

        int[] weight = new int[N];
        int[] value = new int[N];

        // 각 물건의 무게와 가치 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K + 1];

        // 0/1 Knapsack (1차원 최적화)
        for (int i = 0; i < N; i++) {
            for (int w = K; w >= weight[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - weight[i]] + value[i]);
            }
        }

        // 결과 출력
        System.out.println(dp[K]);
    }
}
