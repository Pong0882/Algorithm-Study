package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_완전이진트리fail {
    static int H;
    static int[] paper;
    static int[] result;
    static int N;
    static int cnt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        N = 1 << H;
        // System.out.println(N);

        st = new StringTokenizer(br.readLine());
        paper = new int[N];
        result = new int[N];
        for (int i = 1; i < N; i++) {
            paper[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(Arrays.toString(paper));
        result[cnt++] = paper[N / 2];
        gogo(0, N, H);
        System.out.println(Arrays.toString(result));

        cnt = 0;
        for (int i = 0; i < H; i++) {
            int num = 1 << i;
            for (int j = 0; j < num; j++) {
                sb.append(result[cnt++]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void gogo(int s, int e, int h) {
        if (h == 1) {
            return;
        }
        int mid = s + (e - s) / 2;
        int a = s + (mid - s) / 2;
        int b = mid + (mid - s) / 2;
        result[cnt++] = paper[a];
        result[cnt++] = paper[b];

        gogo(s, mid, h - 1);
        gogo(mid, e, h - 1);
    }
}
