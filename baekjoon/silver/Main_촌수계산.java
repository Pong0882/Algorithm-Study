package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_촌수계산 {
    static int N;
    static int start, end;
    static int re;

    static ArrayList<Integer>[] list;

    static int result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        re = Integer.parseInt(br.readLine());
        for (int i = 0; i < re; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        ArrayDeque<Integer[]> q = new ArrayDeque<>();
        q.add(new Integer[] { start, 0 });
        while (!q.isEmpty()) {
            Integer[] cur = q.poll();
            int node = cur[0];
            int time = cur[1];
            visited[node] = true;
            if (node == end) {
                System.out.println(time);
                return;
            }
            for (Integer next : list[node]) {
                if (visited[next]) {
                    continue;
                }
                q.add(new Integer[] { next, time + 1 });
            }
        }
        System.out.println(-1);
    }
}