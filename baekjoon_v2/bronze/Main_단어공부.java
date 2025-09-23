package baekjoon_v2.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_단어공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        int[] paper = new int[26];
        int max = 0;
        int count = 0;
        int result = 0;

        for (int i = 0; i < S.length(); i++) {
            int a = S.charAt(i);

            int b = (a - 65) % 32;
            paper[b]++;
            max = Math.max(max, paper[b]);
        }

        for (int i = 0; i < 26; i++) {
            if (paper[i] == max) {
                count++;
                result = paper[i];
            }
        }

        System.out.println(count > 1 ? "?" : (char) (result + 'A'));
    }
}
