package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_문제집 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static ArrayList<Integer>[] lists;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int[] indeg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        indeg = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            indeg[e]++;
            lists[s].add(e);
        }

        for (int i = 1; i < N + 1; i++) {
            if (indeg[i] == 0) {
                pq.add(i);
            }
        }
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(" ");
            for (int next : lists[cur]) {
                indeg[next]--;
                if (indeg[next] == 0) {
                    pq.add(next);
                }
            }
        }
        System.out.println(sb);
    }
}
