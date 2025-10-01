package baekjoon_v2.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_수열 {
    static int N, K;
    static int[] paper;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        paper = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            paper[i] = Integer.parseInt(st.nextToken());
        }
        int tmp = 0;
        for (int i = 0; i < K; i++) {
            tmp += paper[i];
        }
        result = tmp;
        for (int i = K; i < N; i++) {
            tmp += paper[i] - paper[i - K];
            result = Math.max(tmp, result);
        }
        System.out.println(result);
    }
}
