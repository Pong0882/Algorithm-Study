package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Symmetry {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        System.out.println(countCows(N, M));
    }

    private static long countCows(long N, long M) {
        long cows = 0;

        // 반복적으로 격자의 크기를 줄여가며 중앙에 소를 배치
        while (N > 0 && M > 0) {
            // 현재 격자에서 소를 배치할 수 있는가?
            if (N % 2 == 1 && M % 2 == 1) {
                cows++;
            }

            // 격자를 절반으로 나눔
            N /= 2;
            M /= 2;
        }

        return cows;
    }
}
