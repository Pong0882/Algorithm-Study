package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_두수의합 {
    private static int n;
    private static int[] card;
    private static int x;

    private static int result;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        card = new int[n];
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        x = Integer.parseInt(br.readLine());

        int point1 = 0;
        int point2 = n - 1;
        while (true) {

            if (point1 >= point2)
                break;

            int tmp = card[point1] + card[point2];

            if (tmp == x) {
                result++;
                point1++;
                point2--;
                continue;
            }
            if (tmp < x) {
                point1++;
            } else {
                point2--;
                continue;
            }
        }
        // System.out.println(Arrays.toString(card));
        System.out.println(result);
    }
}
