package algorithm.LIS;

import java.io.*;
import java.util.*;

public class DP_가장긴증가부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 수열 길이
        int[] arr = new int[n]; // 입력 수열
        int[] dp = new int[n]; // LIS 길이 저장

        StringTokenizer st = new StringTokenizer(br.readLine()); // 수열 입력
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1; // 자기 자신만 포함할 경우 길이는 1
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(dp));

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        int max = 0;
        for (int len : dp)
            max = Math.max(max, len);
        System.out.println(max);
    }
}