package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_거짓말 {
    static int n, m;
    static int[] boss;
    static int result;
    static int[][] input;
    static boolean[] lierArr;
    static ArrayList<Integer>[] liers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // 보스
        boss = new int[n + 1];
        lierArr = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            boss[i] = i;
        }
        // 거짓말쟁이
        st = new StringTokenizer(br.readLine());
        int lier = Integer.parseInt(st.nextToken());
        for (int i = 0; i < lier; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            boss[tmp] = 0;
        }

        liers = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            liers[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int mem = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            liers[i].add(a);
            for (int j = 0; j < mem - 1; j++) {
                int b = Integer.parseInt(st.nextToken());
                liers[i].add(b);
                Union(a, b);
            }
        }
        // System.out.println(Arrays.toString(boss));
        int result = m;
        for (int i = 0; i < m; i++) {
            // System.out.println(liers[i]);
            for (int people : liers[i]) {
                if (bossfind(boss[people]) == 0) {
                    result--;
                    break;
                }
            }
        }
        System.out.println(result);
    }

    private static void Union(int x, int y) {
        int a = bossfind(x);
        int b = bossfind(y);

        if (a < b) {
            boss[b] = a;
        } else {
            boss[a] = b;
        }
    }

    private static int bossfind(int x) {
        if (x == boss[x]) {
            return x;
        }
        return boss[x] = bossfind(boss[x]);
    }
}
