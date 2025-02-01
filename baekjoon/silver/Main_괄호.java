package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int stack = 0;

            for (int j = 0; j < s.length(); j++) {
                char tmp = s.charAt(j);

                if (tmp == '(') {
                    stack++;
                } else {
                    stack--;
                    if (stack < 0) {
                        System.out.println("NO");
                        break;
                    }
                }

                if (j + 1 == s.length()) {
                    if (stack == 0) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            }
        }
    };
}
