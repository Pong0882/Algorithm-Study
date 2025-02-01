package ssafy.ssafygit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EmergencyEscape {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int A, B, N, M, result;
    private static int[] speed;
    private static int[] height;

    private static int boom;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        speed = new int[N];
        height = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            speed[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        boom = -1;
        for (int i = 2; i < N; i++) {
            check1(i);
            if (i > 2)
                check2(i);
            if (i > 3)
                check3(i);
            if (boom != -1) {
                break;
            }
        }

        System.out.println(boom);
        // paper = new int[N];
        // st = new StringTokenizer(br.readLine());
        // for (int i = 0; i < N; i++) {
        // paper[i] = Integer.parseInt(st.nextToken());
        // }
    }

    private static void check1(int n) {
        int r = (speed[n - 1] + speed[n - 2]) / 2;
        int c = height[n] - height[n - 2];
        if (r >= 1100 || c >= 2000) {
            boom = n + 1;
        }
    }

    private static void check2(int n) {
        int r = (speed[n - 1] + speed[n - 2] + speed[n - 3]) / 3;
        int c = height[n] - height[n - 3];
        if (r >= 1000 || c >= 3000) {
            boom = n + 1;
        }
    }

    private static void check3(int n) {
        int r = (speed[n - 1] + speed[n - 2] + speed[n - 3] + speed[n - 4]) / 4;
        int c = height[n] - height[n - 4];
        if (r >= 900 || c >= 4000) {
            boom = n + 1;
        }
    }
}
