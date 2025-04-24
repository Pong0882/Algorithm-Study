package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_겹치는건싫어 {
    static int N, K;
    static int[] paper;
    static int result;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        paper = new int[N];
        for (int i = 0; i < N; i++) {
            paper[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        visited = new int[N];
        while (true) {

        }
    }
}
