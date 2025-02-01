package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_영화감독숌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        // sb.append(i).append(' ');

        int n = Integer.parseInt(br.readLine()); // 숫자하나 받기
        int num = 0;
        int cnt = 0;
        while (true) {
            num++;
            String s = Integer.toString(num);

            if (s.contains("666")) {
                cnt++;
            }

            if (cnt == n) {
                break;
            }
        }

        System.out.println(num);
    };
}
