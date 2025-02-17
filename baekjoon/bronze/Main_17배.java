package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_17배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c = br.readLine().toCharArray();

        int[] a = new int[c.length + 4];
        int[] b = new int[c.length + 4];
        int[] result = new int[b.length + 1];
        for (int i = 0; i < c.length; i++) {
            a[i] = c[c.length - i - 1] - '0';
            b[i + 4] = a[i];
        }
        // System.out.println(Arrays.toString(a));
        // System.out.println(Arrays.toString(b));

        for (int i = 0; i < b.length; i++) {
            result[i] = a[i] + b[i];
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 2) {
                result[i + 1]++;
                result[i] = 0;
            }
            if (result[i] == 3) {
                result[i + 1]++;
                result[i] = 1;
            }
        }
        // System.out.println(Arrays.toString(result));
        if (result[result.length - 1] == 0) {
            for (int i = 1; i < result.length; i++) {
                System.out.print(result[result.length - i - 1]);
            }
        } else {
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[result.length - i - 1]);
            }
        }
    }
}
