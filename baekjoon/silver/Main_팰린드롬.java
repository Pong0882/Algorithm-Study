package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_팰린드롬 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c = br.readLine().toCharArray();

        char mid = ' ';
        char[] alp = new char[26];
        for (int i = 0; i < c.length; i++) {
            alp[c[i] - 'A']++;
        }

        int oddCnt = 0;
        for (int i = 0; i < 26; i++) {
            if (alp[i] == 0) {
                continue;
            }
            if (alp[i] % 2 == 1) { // 홀수니~~?
                oddCnt++;
                mid = (char) (i + 'A'); // 일단 기억해봐~
            }

            int repe = alp[i] / 2;
            char tmp = (char) (i + 'A');
            for (int j = 0; j < repe; j++) {
                sb.append(tmp);
            }

        }
        if (oddCnt == 1) {
            sb.append(mid);
        } else if (oddCnt > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        for (int i = 25; i >= 0; i--) {
            if (alp[i] == 0) {
                continue;
            } else {
                int repe = alp[i] / 2;
                char tmp = (char) (i + 'A');
                for (int j = 0; j < repe; j++) {
                    sb.append(tmp);
                }
            }
        }
        System.out.println(sb);
    }
}
