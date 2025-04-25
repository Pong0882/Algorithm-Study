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
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        paper = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            paper[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, paper[i]);
        }
        int left = 0;
        int right = 0;
        visited = new int[max+1];
        while (right < N && left < N) {
            // System.out.println("left : " + left + ", right : " + right);
            // System.out.println("visited[paper[right]] : " + visited[paper[right]] + " ,
            // paper[right] : "+ paper[right]);
            if (visited[paper[right]] >= K) {
                visited[paper[left++]]--;
                cnt--;
            } else {
                visited[paper[right++]]++;
                cnt++;
            }
            result = Math.max(cnt, result);
        }
        System.out.println(result);
    }
}
