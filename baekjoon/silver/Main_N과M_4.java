package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_N과M_4 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, R;
    // private static int[] visited;
    // 애초에 다음칸으로 들어가버리면 방문 여부를 체크할 필요도 없다.
    private static int[] result;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // visited = new int[N];
        result = new int[R];

        Combi(0, 0);
        System.out.println(sb);
    }

    private static void Combi(int cnt, int start) {
        // base condition
        if (cnt == R) {
            for (int num : result) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            result[cnt] = i + 1;
            Combi(cnt + 1, i);
        }
    }
}
