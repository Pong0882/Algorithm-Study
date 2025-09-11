package baekjoon_v2.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] paper = new boolean[M + 1];
        paper[0] = paper[1] = true;

        for (int i = 2; i < Math.sqrt(M) + 1; i++) {
            for (int j = i + i; j < M + 1; j += i) {
                paper[j] = true;
            }
        }

        for (int i = N; i < M + 1; i++) {
            if (!paper[i]) {
                sb.append(i);
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}