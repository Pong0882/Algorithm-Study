package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_사과담기게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int j = Integer.parseInt(br.readLine());

        int move = 0;
        int left = 1;
        int right = M;
        for (int i = 0; i < j; i++) {
            int drop = Integer.parseInt(br.readLine());

            if (drop > right) {
                int tmp = drop - right;
                move += tmp;
                left += tmp;
                right += tmp;
            } else if (drop < left) {
                int tmp = left - drop;
                move += tmp;
                left -= tmp;
                right -= tmp;
            }
        }
        System.out.println(move);
    }
}
