package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main_1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            int cnt = 0;
            int r = 1;
            while (true) {
                cnt++;
                r = r % n;
                if (r == 0) {
                    break;
                }
                r = r * 10 + 1;
            }
            System.out.println(cnt);
        }

    }
}
