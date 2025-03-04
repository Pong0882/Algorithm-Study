
package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_곡선자르기v2 {
    static int[][] edge;
    static int minR = Integer.MAX_VALUE;
    static int maxR = Integer.MIN_VALUE;
    static int midLine;
    static int[] value;
    static int result1, result2;
    static int maxi = 2000000000;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int minuscheck = -2;
        int start = -2;
        ArrayList<Integer[]> tempList = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        float check = 1;
        int tmpPeek = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // ==================================
            // if (c < 0) {
            // if (c > 0 && minuscheck + 1 == i) {
            // start = minuscheck;
            // Integer[] tmp = tempList.get(tempList.size() - 1);
            // stack.push(tmp[0]);
            // }
            // if (c < 0) {
            // minuscheck = i;
            // }
            // tempList.add(new Integer[] { r, c });
            // } else {
            // float sign = Math.signum(c);
            // if (sign != check) {
            // if (!stack.contains(value[i])) {
            // stack.push(value[i]);
            // tmpPeek = stack.peek();
            // } else {
            // if (tmpPeek == stack.peek()) {
            // result2++;
            // }
            // stack.pop();
            // if (stack.isEmpty()) {
            // result1++;
            // }
            // }
            // check = -check;
            // }
            // }
            // System.out.println(start);
        }
        System.out.println("==============");
        for (Integer[] a : tempList) {
            System.out.println(a[0] + " " + a[1]);
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int tmp = 0;
        for (int i = 0; i < value.length; i++) {
            if (value[i] != 0) {
                if (!q.contains(value[i])) {
                    q.push(value[i]);
                    tmp = q.peek();
                } else {
                    if (tmp == q.peek()) {
                        result2++;
                    }
                    q.pop();
                    if (q.isEmpty()) {
                        result1++;
                    }
                }
            }
        }
        System.out.println(result1 + " " + result2);
    }
}
