package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_근손실 {
    static int N, K;
    static int[] paper;
    static int[] select;
    static int result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        paper = new int[N];
        select = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            paper[i] = Integer.parseInt(st.nextToken());
        }

        perm(0);
        System.out.println(result);
    }

    private static void perm(int cnt) {
        if (cnt == N) {
            check();
            // System.out.println(Arrays.toString(select));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            select[cnt] = paper[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }

    private static void check() {
        int check = 0;
        for (int i = 0; i < N; i++) {
            check += select[i] - K;
            if (check < 0) {
                return;
            }
        }
        result++;
    }
}
