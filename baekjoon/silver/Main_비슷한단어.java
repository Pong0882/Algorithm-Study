package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_비슷한단어 {
    static int N;
    static int[] start;
    static int[] paper;
    static int cnt;
    static String tmp;
    static int result;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tmp = br.readLine();
        start = new int[26];
        for (int i = 0; i < tmp.length(); i++) {
            int a = tmp.charAt(i) - 'A';
            start[a]++;
        }

        paper = new int[26];

        for (int i = 1; i < N; i++) {
            paper = Arrays.copyOf(start, start.length);
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < c.length; j++) {
                int a = (c[j] - 'A');
                paper[a]--;
            }
            int up = 0;
            int down = 0;
            for (int j = 0; j < 26; j++) {
                if (paper[j] > 0) {
                    up += paper[j];
                } else if (paper[j] < 0) {
                    down += paper[j];
                }
            }
            if (up < 2 && down > -2) {
                result++;
            }
            // System.out.println(Arrays.toString(paper));
        }
        System.out.println(result);
    }
}
