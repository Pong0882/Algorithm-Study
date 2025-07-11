package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.temporal.ValueRange;
import java.util.StringTokenizer;

public class Main_용액 {
    static int N;
    static int[] paper;
    static int a, b, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        paper = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            paper[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = N - 1;
        int a = paper[l];
        int b = paper[r];

        int sum = a + b;
        result = a + b;

        while (l < r) {

            if (sum == 0) {
                break;
            } else if (sum < 0) {
                sum -= paper[l++];
                sum += paper[l];
            } else {
                sum -= paper[r--];
                sum += paper[r];
            }

            if (l == r) {
                break;
            }

            if (Math.abs(sum) < Math.abs(result)) {
                a = paper[l];
                b = paper[r];
                result = sum;
            }
        }
        System.out.println(a + " " + b);
    }
}
