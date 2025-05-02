package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_랩실에서잘자요 {
    static int N, M;
    static int[] paper;
    static int result;
    static int cnt;
    static boolean[] check;
    static boolean start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        check = new boolean[M + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            check[Integer.parseInt(st.nextToken())] = true;
        }

        // System.out.println(Arrays.toString(check));
        for (int i = 1; i <= M; i++) {
            if (!check[i]) { // 이거 인쇄해야해
                if (cnt < 3) {
                    result += cnt * 2;
                    cnt = 0;
                } else {
                    start = false;
                    cnt = 0;
                }
                if (start) { // 시작했어
                    result += 2;
                } else { // 처음시작이야
                    start = true;
                    result += 7;
                }
            } else { // 이거 인쇄 안해도되는거긴해
                if (start) {
                    cnt++;
                }
            }
            System.out.println(i + " : " + result + " / cnt : " + cnt);
        }
        System.out.println(result);
    }
}
