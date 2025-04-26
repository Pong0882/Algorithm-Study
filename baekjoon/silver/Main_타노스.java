package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_타노스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c = br.readLine().toCharArray();

        boolean[] flag = new boolean[2];
        flag[1] = true;
        StringBuilder sb = new StringBuilder();

        for (char ch : c) {
            int num = ch - '0';
            flag[num] = !flag[num];
            if (flag[num]) {
                sb.append(ch);
            }
        }
        System.out.println(sb);
    }
}
