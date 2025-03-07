package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_ROT13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i);

            if (tmp >= 65) {

                if (tmp <= 65 + 12) {
                    sb.append((char) (tmp + 13));
                } else if (tmp <= 65 + 26) {
                    sb.append((char) (tmp - 13));
                } else if (tmp <= 97 + 12) {
                    sb.append((char) (tmp + 13));
                } else if (tmp <= 97 + 26) {
                    sb.append((char) (tmp - 13));
                }

            } else {
                sb.append((char) tmp);
            }
        }
        System.out.println(sb);
    }
}
