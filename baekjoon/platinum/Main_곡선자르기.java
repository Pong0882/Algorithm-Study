package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_곡선자르기 {
    static int[][] edge;
    static int minR = Integer.MAX_VALUE;
    static int maxR = Integer.MIN_VALUE;
    static int midLine;
    // static int[] value;
    static TreeMap<Integer, Integer> value;
    static int result1, result2;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        edge = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            edge[i][0] = Integer.parseInt(st.nextToken());
            edge[i][1] = Integer.parseInt(st.nextToken());
            minR = Math.min(edge[i][0], minR);
            maxR = Math.max(edge[i][0], maxR);
        }
        value = new TreeMap<>();

        int start = 0;
        for (int i = 1; i < n; i++) {
            int c = edge[i - 1][1];
            int cc = edge[i][1];
            if (c < 0 && cc > 0) {
                start = i - 1;
            }
        }

        int cnt = 2;
        double beforeSign = Math.signum(edge[start][1]);
        for (int i = start + 1; i < n + start; i++) {
            int idx = i % n;

            if (Math.signum(edge[idx][1]) != beforeSign) {
                value.put(edge[idx][0] - minR, cnt++ / 2);
                // value[edge[idx][0] - minR] = cnt++ / 2;
            }
            beforeSign = Math.signum(edge[idx][1]);
        }
        // List<Integer> keySet = new ArrayList<>(value.keySet());
        // Collections.sort(keySet);
        // System.out.println(Arrays.toString(value));
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        int tmp = 0;
        for (int key : value.keySet()) {
            int v = value.get(key);
            if (!visited.contains(v)) { // 빠른 탐색을 위해 HashSet 사용
                stack.push(v);
                visited.add(v);
                tmp = v;
            } else {
                if (stack.peek() == tmp) {
                    result2++;
                }
                stack.pop();
                if (stack.isEmpty()) {
                    result1++;
                }
            }
        }
        // int tmp = 0;
        // for (Integer key : value.keySet()) {
        // if (!q.contains(value.get(key))) {
        // q.push(value.get(key));
        // tmp = q.peek();
        // } else {
        // if (tmp == q.peek()) {
        // result2++;
        // }
        // q.pop();
        // if (q.isEmpty()) {
        // result1++;
        // }
        // }
        // }
        // System.out.println(value);
        System.out.println(result1 + " " + result2);
    }
}
