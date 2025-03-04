package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_막대기 {
    static int[] stick = { 64, 32, 16, 8, 4, 2, 1 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i < 7; i++) {
            if (N == 0) {
                break;
            }
            if (stick[i] > N) {
                continue;
            }
            N -= stick[i];
            result++;
            // System.out.println(N);
        }
        System.out.println(result);
    }
}