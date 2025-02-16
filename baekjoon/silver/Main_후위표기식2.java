
package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_후위표기식2 {
    private static int N;
    private static ArrayDeque<Double> queue = new ArrayDeque<>();
    private static String s;
    private static Map<Integer, Integer> map = new HashMap<>();
    private static int[] arr;
    private static int[] check;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        char[] c = br.readLine().toCharArray();
        check = new int[N];
        arr = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 'A' && c[i] <= 'Z') {
                int tmp;
                if (check[c[i] - 'A'] != 0) {
                    tmp = Integer.parseInt(br.readLine());
                    check[c[i] - 'A'] = tmp;
                } else {
                    tmp = check[c[i] - 'A'];
                }
                // map.put(c[i] - 'A', tmp);
                arr[i] = tmp;
            } else {
                arr[i] = c[i] - 50;
            }
        }

        Double a, b;
        for (int i = 0; i < c.length; i++) {
            if (arr[i] >= 0) {
                queue.offer((double) (arr[i]));
            } else {
                a = queue.pollLast();
                b = queue.pollLast();
                switch (arr[i]) {
                    case -8:
                        queue.offer(a * b);
                        break;
                    case -7:
                        queue.offer(a + b);
                        break;
                    case -3:
                        queue.offer(b / a);
                        break;
                    case -5:
                        queue.offer(b - a);
                        break;

                }
            }
        }
        System.out.printf("%.2f", queue.peek());
        // System.out.println(Arrays.toString(arr));
    }
}