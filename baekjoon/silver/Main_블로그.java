package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_블로그 {
    static int N, X;
    static int[] paper;
    static int max;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        paper = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            paper[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += paper[i];
        }
        max = sum;
        for (int i = X; i < N; i++) {
            sum += paper[i] - paper[i - X];
            max = Math.max(sum, max);
        }
        // System.out.println(max);

        sum = 0;
        for (int i = 0; i < X; i++) {
            sum += paper[i];
        }
        if (sum == max) {
            result++;
        }
        for (int i = X; i < N; i++) {
            sum += paper[i] - paper[i - X];
            if (sum == max) {
                result++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(result);
        }
    }
}
