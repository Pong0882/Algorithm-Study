package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_완전이진트리 {
<<<<<<< HEAD
    static int k;
    static int n;
    static StringBuilder sb = new StringBuilder();
    static int[] paper;
=======
    static int H;
    static int[] paper;
    static int[] result;
    static int N;
    static int cnt;
    static StringBuilder sb = new StringBuilder();
>>>>>>> 3325e1c12304c41e2e29aabd34a050ca4c9b6a41

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
<<<<<<< HEAD
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

=======
        H = Integer.parseInt(st.nextToken());
        N = 1 << H;
        // System.out.println(N);

        st = new StringTokenizer(br.readLine());
        paper = new int[N - 1];
        result = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            paper[i] = Integer.parseInt(st.nextToken());
        }
        // System.out.println(Arrays.toString(paper));
        // result[cnt++] = paper[N / 2];
        gogo(1);
        // System.out.println(Arrays.toString(result));

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

    private static void gogo(int n) {
        if (n >= N - 1) {
            return;
        }
        gogo(n * 2);
        int tmp = n;
        while (tmp < N) {
            result[cnt++] = paper[tmp - 1];
            tmp += n * 2;
        }
>>>>>>> 3325e1c12304c41e2e29aabd34a050ca4c9b6a41
    }
}
