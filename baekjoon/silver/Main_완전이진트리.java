package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_완전이진트리 {
    static int k;
    static int n;
    static StringBuilder sb = new StringBuilder();
    static int[] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = (1 << k) - 1;
        // System.out.println(n);
        st = new StringTokenizer(br.readLine());
        paper = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            paper[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(Arrays.toString(paper));
        gogo(1);
        System.out.println(sb);
    }

    private static void gogo(int node) {
        int left = node * 2;
        if (left <= n) {
            gogo(left);
        }
        sb.append(paper[node]);
        int right = node * 2 + 1;
        if (right <= n) {
            gogo(right);
        }

    }
}
