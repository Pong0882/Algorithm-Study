package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Symmetry {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        System.out.println(countCows(N, M));
    }

    private static long countCows(long N, long M) {
        if (N == 0 || M == 0 || N % 2 == 0 || M % 2 == 0) {
            return 0;
        }

        return 1 + 4 * countCows(N / 2, M / 2);
    }
}