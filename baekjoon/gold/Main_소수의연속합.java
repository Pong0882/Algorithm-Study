package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_소수의연속합 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] primes = new int[283148];
        int count = 0;

        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes[count++] = i;
            }
        }

        int answer = 0;
        int s = 0, e = 0;
        int sum = 0;

        while (true) {
            if (sum >= n) {
                if (sum == n) {
                    answer++;
                }
                sum -= primes[s++];
            } else {
                if (e == count)
                    break;
                sum += primes[e++];
            }
        }

        System.out.println(answer);
    }
}
