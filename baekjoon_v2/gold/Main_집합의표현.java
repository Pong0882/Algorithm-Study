package baekjoon_v2.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_집합의표현 {
    static int[] boss;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boss = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            boss[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int comm = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (comm == 1) {
                sb.append(find(a) == find(b) ? "YES" : "NO").append('\n');
            } else {
                Union(a, b);
            }
        }
        System.out.println(sb);
    }

    static int find(int x) {
        if (boss[x] == x)
            return x;
        return boss[x] = find(boss[x]); // 경로 압축
    }

    private static void Union(int a, int b) {
        int ar = find(a);
        int br = find(b);
        if (ar == br)
            return;

        boss[br] = ar;
        return;
    }
}
