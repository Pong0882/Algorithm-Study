package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_하노이탑 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = (1 << n) - 1;

        sb.append(cnt).append("\n");

        hanoi(1, 2, 3, n);
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
