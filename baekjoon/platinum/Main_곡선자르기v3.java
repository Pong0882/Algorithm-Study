
package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_곡선자르기v3 {
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
        ArrayList<Integer[]> tempList = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int cutIdx = -2;
        float sign = -1;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // ==============================
            if (cutIdx == -2) {
                if (c > 0) {
                    tempList.add(new Integer[] { r, c });
                }
                if (c < 0) {
                    cutIdx = i;
                }
            } else {
                float rsign = Math.signum(c);
                if (rsign != sign) { // 관통
                    if (!stack.contains(c)) {
                        stack.push(c);
                        tmp = stack.peek();
                    } else {
                        if (tmp == stack.peek()) {
                            result2++;
                        }
                        stack.pop();
                        if (stack.isEmpty()) {
                            result1++;
                        }
                    }
                }
            }
        }
        System.out.println(tempList.size());
        System.out.println(result1 + " " + result2);
    }
}
