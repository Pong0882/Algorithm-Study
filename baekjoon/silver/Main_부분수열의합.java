package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_부분수열의합 {
    static int N;
    static boolean[] select;
    static int result;
    static int[] paper;
    static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        paper = new int[N];
        select = new boolean[N];
        for (int i = 0; i < N; i++) {
            paper[i] = Integer.parseInt(st.nextToken());
        }

        subset(0);
        System.out.println(S == 0 ? result - 1 : result);
    }

    private static void subset(int cnt) {
        if (cnt == N) {
            check();
            return;
        }
        select[cnt] = true;
        subset(cnt + 1);
        select[cnt] = false;
        subset(cnt + 1);
    }

    private static void check() {
        int tmp = 0;
        for (int i = 0; i < N; i++) {
            if (select[i]) {
                tmp += paper[i];
            }
        }
        if (tmp == S) {
            result++;
        }
    }
}
