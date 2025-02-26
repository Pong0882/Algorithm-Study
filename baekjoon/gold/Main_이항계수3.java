package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이항계수3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Integer.parseInt(st.nextToken());
        long K = Integer.parseInt(st.nextToken());
        long P = 1000000007;
        long result = 1;

        // numerator: N! % P
        for (int i = 1; i <= N; i++) {
            result = (result * i) % P;
        }

        // tmp: (K! * (N-K)!) % P
        long tmp = 1;
        for (int i = 1; i <= K; i++) {
            tmp = (tmp * i) % P;
        }
        for (int i = 1; i <= N - K; i++) {
            tmp = (tmp * i) % P;
        }
        // 페르마의 소정리
        long inverse = modPow(tmp, P - 2, P);

        result = (result * inverse) % P;
        System.out.println(result);
    }

    private static long modPow(long base, long exp, long mod) {
        long ret = 1;
        base %= mod;
        while ((exp > 0)) {
            if ((exp & 1) == 1) {
                ret = (ret * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return ret;
    }
}
