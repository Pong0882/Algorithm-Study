package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_이친수 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long a = 1;
        long b = 1;
        long tmp = 0;
        for (int i = 0; i < n - 2; i++) {
            tmp = b;
            b += a;
            a = tmp;
        }
        System.out.println(b);
    }
}
