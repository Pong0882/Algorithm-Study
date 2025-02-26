package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_농구경기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int al = 'z' - 'a' + 1;
        int[] check = new int[al];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            check[s.charAt(0) - 'a']++;
        }
        // System.out.println(Arrays.toString(check));
        boolean b = false;
        char tmp = 'a';
        for (int i = 0; i < al; i++, tmp++) {
            if (check[i] >= 5) {
                sb.append(tmp);
                b = true;
            }

        }
        System.out.println(b ? sb : "PREDAJA");
    }
}
