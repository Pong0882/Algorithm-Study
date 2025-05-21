package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_AB_v2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int answer = 1;

        while (A < B) {
            if (B % 10 == 1) {
                B /= 10;
                answer++;
            } else if ((B & 1) == 0) {
                B = B >> 1;
                answer++;
            } else {
                break;
            }
        }
        System.out.println(A == B ? answer : -1);
    }

}
