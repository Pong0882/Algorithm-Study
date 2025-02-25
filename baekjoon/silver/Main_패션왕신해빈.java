package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_패션왕신해빈 {
    static StringBuilder sb = new StringBuilder();

    static int T, N;
    static Map<String, Integer> map;
    static int[] count;
    static boolean[] select;
    static int result;
    static int size;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int TC = 0; TC < T; TC++) {
            result = 0;
            N = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String where = st.nextToken();

                // map.putIfAbsent(where, );
                map.compute(where, (k, v) -> (v == null) ? 1 : v + 1);
            }
            size = map.size();
            count = new int[size];
            select = new boolean[size];
            int idx = 0;
            for (String string : map.keySet()) {
                count[idx++] = map.get(string);
            }
            subset(0);
            // for (String string : map.keySet()) {
            // System.out.println(string);
            // }
            sb.append(result - 1).append("\n");
        }
        System.out.println(sb);
    }

    private static void subset(int cnt) {
        if (cnt == size) {
            // System.out.println(Arrays.toString(count));
            oper();
            return;
        }
        select[cnt] = true;
        subset(cnt + 1);
        select[cnt] = false;
        subset(cnt + 1);
    }

    private static void oper() {
        int tmp = 1;
        for (int i = 0; i < size; i++) {
            if (select[i]) {
                tmp *= count[i];
            }
        }
        result += tmp;
    }
}
