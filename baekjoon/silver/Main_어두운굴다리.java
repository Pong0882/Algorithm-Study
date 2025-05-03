package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_어두운굴다리 {
    static int N;
    static int M;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        result = Integer.parseInt(st.nextToken());
        int before = result;
        for (int i = 1; i < M; i++) {
            int cur = Integer.parseInt(st.nextToken());
            result = Math.max(result, (cur - before + 1) / 2);
            before = cur;
        }
        result = Math.max(result, N - before);
        System.out.println(result);
    }
}
