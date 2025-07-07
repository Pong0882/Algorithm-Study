package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_행성터널v2 {
    static class Edge implements Comparable<Edge> {
        int e, w;
        int s;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(w, o.w);
        }
    }

    static class Planet {
        int x, y, z, idx;

        public Planet(int x, int y, int z, int idx) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.idx = idx;
        }
    }

    static ArrayList<Edge> points = new ArrayList<>();
    static int[] list;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] memo = new int[N][3];
        Planet[] planets = new Planet[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            memo[i][0] = Integer.parseInt(st.nextToken());
            memo[i][1] = Integer.parseInt(st.nextToken());
            memo[i][2] = Integer.parseInt(st.nextToken());
            planets[i] = new Planet(memo[i][0], memo[i][1], memo[i][2], i);
        }

        points = new ArrayList<>(); //

        Arrays.sort(planets, (a, b) -> Integer.compare(a.x, b.x));
        for (int i = 0; i < N - 1; i++) {
            int w = Math.abs(planets[i].x - planets[i + 1].x);
            points.add(new Edge(planets[i].idx, planets[i + 1].idx, w));
        }

        Arrays.sort(planets, (a, b) -> Integer.compare(a.y, b.y));
        for (int i = 0; i < N - 1; i++) {
            int w = Math.abs(planets[i].y - planets[i + 1].y);
            points.add(new Edge(planets[i].idx, planets[i + 1].idx, w));
        }

        Arrays.sort(planets, (a, b) -> Integer.compare(a.z, b.z));
        for (int i = 0; i < N - 1; i++) {
            int w = Math.abs(planets[i].z - planets[i + 1].z);
            points.add(new Edge(planets[i].idx, planets[i + 1].idx, w));
        }

        Collections.sort(points);

        list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = i;
        }

        int cnt = 0;

        for (Edge tmp : points) {
            if (find(tmp.s) != find(tmp.e)) {
                union(tmp.s, tmp.e);
                result += tmp.w;
                cnt++;
                if (cnt == N - 1)
                    break;
            }
        }

        System.out.println(result);
    }

    static int find(int x) {
        if (list[x] != x) {
            list[x] = find(list[x]);
        }
        return list[x];
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            list[y] = x;
        }
    }
}