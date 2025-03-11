package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_학교탐방하기 {
    static int N, M;
    static long result;

    static class Edge implements Comparable<Edge> {
        int e, w;

        public Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(o.w, w);
        }

    }

    static ArrayList<Edge>[] list;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long max = 0;
        PriorityQueue<Edge> points = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        int aa = Integer.parseInt(st.nextToken());
        int bb = Integer.parseInt(st.nextToken());
        int ww = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (w == 0) {
                max++;
            }
            list[s].add(new Edge(e, w));
            list[e].add(new Edge(s, w));
        }
        visited = new boolean[N + 1];
        int cnt = 0;
        points.add(new Edge(bb, ww));
        visited[aa] = true;
        if (ww == 0) {
            result++;
            max++;
        }

        while (!points.isEmpty()) {
            if (cnt == N - 1) {
                break;
            }
            Edge tmp = points.poll();
            if (visited[tmp.e]) {
                continue;
            }

            visited[tmp.e] = true;
            if (tmp.w == 0) {
                result++;
            }
            cnt++;

            for (Edge edge : list[tmp.e]) {
                if (visited[edge.e]) {
                    continue;
                }
                points.add(edge);
            }
        }
        max *= max;
        result *= result;
        System.out.println(max - result);

    }
}
