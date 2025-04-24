package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_회전초밥 {
    static int N, d, K, c;
    static boolean[] check;
    static int result;
    static int[] paper;
    static int resultTmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        check = new boolean[d + 1];
        paper = new int[N];
        for (int i = 0; i < N; i++) {
            paper[i] = Integer.parseInt(br.readLine());
        }

        int left = 0;
        int right = K-1;
        for (int i = left; i <= right; i++) {
            if (paper[i] == c) {
                right++;
            }
            if (check[paper[i]]) {
                continue;
            } else {
                check[paper[i]] = true;
                resultTmp++;
            }
        }

        result = resultTmp;
        int resultTmp = 0;
        for (int i = 0; i < N; i++) {
            left = (left + 1) % N;
            right = (right + 1) % N;

            if (paper[left - 1] == c) {
                right++;
            }
            if (check[paper[left - 1]]) {
                check[paper[left - 1]] = false;
                resultTmp--;
            } else {
                check[paper[left - 1]] = true;
                resultTmp++;
            }

            if (check[paper[right]]) {
                continue;
            } else {
                check[paper[right]] = true;
                resultTmp++;
            }

            result = Math.max(result, resultTmp);
        }
        
        System.out.println();
        System.out.println(left + " " + right);
        System.out.println(resultTmp);

    }
}
