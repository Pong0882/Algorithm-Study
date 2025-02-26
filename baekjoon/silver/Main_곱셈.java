package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_곱셈 {
    static long A, B, C;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(gogo(B));
    }

    private static long gogo(long b2) {
        if (b2 == 1) {
            return A % C;
        }
        long tmp = gogo(b2 / 2);
        tmp = (tmp * tmp) % C;
        if (b2 % 2 == 1) {
            tmp = (tmp * A) % C;
        }
        return tmp;
    }
}
