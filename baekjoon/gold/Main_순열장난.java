package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String s;
    private static int max;
    private static int tmp;
    private static int[] idxCard;
    private static int depth;
    private static int[] select;
    private static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        if (s.length() > 10) {
            tmp = s.length() - 9;
            tmp /= 2;
            max = 9 + tmp;
        } else {
            max = s.length();
        }
        // System.out.println(max + " " + tmp);
        idxCard = new int[s.length() - 1];

        select = new int[max + 1];
        check = new boolean[max + 1]; // 최대 크기 숫자 만큼 칸 만들어놓고 만들어졌나 확인하자

        dfs(0, 0);
    }

    private static void dfs(int start, int cnt) {
        // System.out.println(Arrays.toString(check));
        // System.out.println(Arrays.toString(select));
        if (cnt == max) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < max; i++) {
                sb.append(select[i]).append(" ");
            }
            System.out.println(sb);
            System.exit(0); // 뿌셔
        }

        if (start > s.length() || cnt >= max) { // 터지지마
            return;
        }
        int n = s.charAt(start) - '0';
        if (n >= 1 && n <= max && !check[n]) { // 1칸 선택
            check[n] = true;
            select[cnt] = n;
            dfs(start + 1, cnt + 1);
            check[n] = false;
        }
        if (start + 1 >= s.length()) { // 터지지마
            return;
        }

        n = (s.charAt(start) - '0') * 10 + s.charAt(start + 1) - '0';
        if (n <= max && n >= 10 && !check[n]) { // 두칸 선택
            check[n] = true;
            select[cnt] = n;
            dfs(start + 2, cnt + 1);
            check[n] = false;
        }

    }
}
