package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_행성터널Fail {
    static class Edge implements Comparable<Edge> {
        int e, w;

        public Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(w, o.w);
        }
    }

    static PriorityQueue<Edge> points = new PriorityQueue<>();

    static ArrayList<Edge>[] list;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] memo = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            memo[i][0] = Integer.parseInt(st.nextToken());
            memo[i][1] = Integer.parseInt(st.nextToken());
            memo[i][2] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList[N];

        int cnt = 0;
        points = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                // list[j].add(new Edge(i, w));
                int w = Math.min(Math.abs(memo[i][0] - memo[j][0]), Math.min(Math.abs(memo[i][1] - memo[j][1]),
                        Math.abs(memo[i][2] - memo[j][2])));
                list[i].add(new Edge(j, w));
            }
        }
        points.add(new Edge(0, 0));
        visited = new boolean[N];
        while (cnt != N) {
            Edge tmp = points.poll();
            if (visited[tmp.e]) {
                continue;
            }
            visited[tmp.e] = true;
            cnt++;
            result += tmp.w;
            for (Edge next : list[tmp.e]) {
                if (visited[next.e]) {
                    continue;
                }
                points.add(next);
            }
        }
        System.out.println(result);
    }
}
