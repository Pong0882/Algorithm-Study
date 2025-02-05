package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_수학숙제 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;

    private static String s;
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                int num = s.charAt(j) - '0';
                String stmp = "";
                if (num < 10 && num > 0) {
                    int startIdx = j;

                    for (int k = j + 1; k < s.length(); k++) {
                        if (k >= s.length()) {
                            break;
                        }
                        int tmp = s.charAt(k) - '0';
                        if (tmp < 0 || tmp >= 10) {
                            break;
                        }
                        j++;
                        stmp = s.substring(startIdx, k + 1);
                    }

                    if (stmp.equals("")) {
                        continue;
                    }
                    list.add(stmp);
                }
            }
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i));
        }
    }
}
