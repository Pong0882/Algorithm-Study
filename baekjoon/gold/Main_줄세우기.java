package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_줄세우기 {
    static int[] check;

    public static void main(String[] args) throws NumberFormatException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        check = new int[N + 1];
        ArrayDeque<Integer> points = new ArrayDeque<>();
        ArrayList<Integer>[] lists = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            check[e]++;
            lists[s].add(e);
        }
        // System.out.println(Arrays.toString(check));
        for (int i = 1; i < N + 1; i++) {
            if (check[i] == 0) {
                points.add(i);
            }
        }
        while (!points.isEmpty()) {
            int tmp = points.poll();
            sb.append(tmp).append(" ");
            for (int next : lists[tmp]) {
                check[next]--;
                if (check[next] == 0) {
                    points.add(next);
                }
            }
        }
        System.out.println(sb);
    }
}
