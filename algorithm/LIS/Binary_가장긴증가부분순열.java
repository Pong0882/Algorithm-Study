package algorithm.LIS;

import java.io.*;
import java.util.*;

public class Binary_가장긴증가부분순열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 수열 길이
        int[] arr = new int[n]; // 입력 수열

        StringTokenizer st = new StringTokenizer(br.readLine()); // 수열 입력
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // System.out.println(Arrays.toString(arr));
        ArrayList<Integer> lis = new ArrayList<>();
        int[] dp = new int[n];

        int cnt = 0;
        for (int num : arr) {
            int idx = Collections.binarySearch(lis, num);
            if (idx < 0)
                idx = -(idx + 1);

            dp[cnt++] = idx;
            if (idx == lis.size())
                lis.add(num);
            else
                lis.set(idx, num);
        }
        // System.out.println(Arrays.toString(dp));
        ArrayDeque<Integer> q = new ArrayDeque<>();
        cnt = lis.size();
        for (int i = n - 1; i >= 0; i--) {
            // System.out.println(dp[i] + " " + cnt);
            if (cnt - 1 == dp[i]) {
                q.push(arr[i]);
                cnt--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append(q.pop()).append(" ");
        }
        System.out.println(lis.size());
        System.out.println(sb);
    }
}