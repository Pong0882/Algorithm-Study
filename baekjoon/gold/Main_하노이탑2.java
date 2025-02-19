package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_하노이탑2 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        BigInteger cnt = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        BigInteger one = new BigInteger("1");
        for (int i = 0; i < n; i++) {
            cnt = cnt.multiply(two);
        }
        cnt = cnt.subtract(one);
        sb.append(cnt).append("\n");

        if (n <= 20) {
            hanoi(1, 2, 3, n);
        }
        System.out.println(sb);
    }

    private static void hanoi(int start, int mid, int end, int n) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
        } else {
            hanoi(start, end, mid, n - 1);
            sb.append(start).append(" ").append(end).append("\n");
            hanoi(mid, start, end, n - 1);
        }
    }
}
