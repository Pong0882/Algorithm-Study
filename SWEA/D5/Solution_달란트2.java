package SWEA.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_달란트2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i < T + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int a = n / m;
            int b = n % m;

            long result = power(a + 1, b);
            result *= power(a, m - b);
            sb.append("#").append(i).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static long power(long base, long exp) {
        if (exp == 0)
            return 1; // x^0 = 1
        if (exp == 1)
            return base; // x^1 = x

        long half = power(base, exp / 2); // 재귀적으로 절반 계산
        long result = half * half; // 절반의 결과를 제곱

        if (exp % 2 != 0) { // 지수가 홀수라면 한 번 더 곱해줌
            result *= base;
        }

        return result;
    }
}
