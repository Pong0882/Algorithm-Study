package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_N과M_7 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int A, B, N, M;
    private static int[] result;
    private static int depth;
    private static int[] card;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        depth = M;

        st = new StringTokenizer(br.readLine());
        card = new int[N];
        result = new int[M];
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        CombiRe(0);
        System.out.println(sb);
    }

    private static void CombiRe(int cnt) {
        if (depth == cnt) {
            for (int i = 0; i < depth; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            result[cnt++] = card[i];
            CombiRe(cnt--);
        }
    }
}
