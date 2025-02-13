package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_순열장난 {
    private static String s;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        if (s.length() > 10) {
            int tmp = s.length() - 9;
            tmp /= 2;
            max = 9 + tmp;
        } else {
            max = s.length();
        }
        System.out.println(max);
    }
}
