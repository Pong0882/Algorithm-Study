package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main_전깃줄2 {
    static final int max = 500001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 수열 길이
        int[] arr = new int[max]; // 입력 수열

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 수열 입력
            int idx = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr[idx] = value;
        }
        // System.out.println(Arrays.toString(arr));
        ArrayList<Integer> lis = new ArrayList<>();
        int[] dp = new int[max];
        Arrays.fill(dp, -10);
        int cnt = 0;
        int result = -1;
        for (int num : arr) {
            result++;
            if (num == 0) {
                continue;
            }
            int idx = Collections.binarySearch(lis, num);
            if (idx < 0) {
                idx = -(idx + 1);
            }

            dp[result] = idx;
            if (idx == lis.size())
                lis.add(num);
            else
                lis.set(idx, num);
        }
        // System.out.println(Arrays.toString(dp));
        ArrayDeque<Integer> q = new ArrayDeque<>();
        cnt = lis.size();
        // System.out.println(cnt);
        for (int i = max - 1; i >= 0; i--) {
            if (dp[i] == -10) {
                continue;
            }
            // System.out.println(i + " " + cnt + " " + dp[i]);
            if (cnt - 1 == dp[i]) {
                cnt--;
            } else {
                q.push(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append(q.pop()).append("\n");
        }
        System.out.println(n - lis.size());
        System.out.println(sb);
    }
}