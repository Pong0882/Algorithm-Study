package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_설탕배달2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long result = -1;
        long mod = n % 5;
        if (mod == 0) {
            result = n / 5;
        }
        if (mod % 2 == 1) {
            result = (n / 5) + 1;
        }
        if (mod == 4) {
            result = n / 5 + 2;
        }
        if (mod == 2) {
            long tmp = n / 30;
            long tmp2 = n % 30;
            if (tmp2 == 12) {
                result = tmp * 6 + 4;
            } else if (tmp2 == 22) {
                result = tmp * 6 + 6;
            } else if (tmp2 == 27) {
                result = tmp * 6 + 9;
            }
        }
        if (n < 5) {
            result = -1;
        }
        System.out.println(result);
    }
}
