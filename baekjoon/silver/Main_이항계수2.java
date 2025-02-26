package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이항계수2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = 10007;
        int result = 1;
        for (int i = 1; i <= N; i++) {
            result *= i;
            if (result > P) {
                result %= P;
            }
        }
        // System.out.println(result);
        int tmp = 1;
        for (int i = 1; i <= N - K; i++) {
            tmp *= i;
            if (tmp > P) {
                tmp %= P;
            }
        }
        // System.out.println(tmp);
        for (int i = 1; i <= K; i++) {
            tmp *= i;
            if (tmp > P) {
                tmp %= P;
            }
        }
        // System.out.println(tmp);
        int a = tmp;
        for (int i = 1; i < P - 2; i++) {
            tmp *= a;
            tmp %= P;
        }

        result *= tmp;
        result %= P;
        System.out.println(result);
    }
}
