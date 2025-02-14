package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_순열장난 {
    private static String s;
    private static int max;
    private static int tmp;
    private static int[] idxCard;
    private static int depth;
    private static int[] select;

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
        System.out.println(max + " " + tmp);
        idxCard = new int[s.length() - 1];

        select = new int[tmp];
        for (int i = 0; i < idxCard.length; i++) {
            idxCard[i] = i;
        }
        System.out.println(Arrays.toString(idxCard));
        depth = tmp;
        combi(0, 0);
    }

    private static void combi(int cnt, int start) {
        if (cnt == depth) {
            System.out.println(Arrays.toString(select));
            return;
        }

        for (int i = start; i < idxCard.length; i++) {
            select[cnt] = i;
            combi(cnt + 1, i + 1);
        }
    }

}
