package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_주식 {
    static int T;
    static int N;
    static int[] paper;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            paper = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                paper[i] = Integer.parseInt(st.nextToken());
            }

            int high = paper[N - 1];
            result = 0;
            for (int i = N - 1; i >= 0; i--) {
                high = Math.max(high, paper[i]);
                result += high - paper[i];
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
