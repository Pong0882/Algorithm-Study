package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_행성터널 {
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

    static class Point implements Comparable<Point> {
        @Override
        public String toString() {
            return "Point [idx=" + idx + ", axis=" + axis + "]";
        }

        int idx, axis;

        public Point(int idx, int axis) {
            this.idx = idx;
            this.axis = axis;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(axis, o.axis);
        }

    }

    static ArrayList<Edge>[] list;
    static boolean[] visited;
    static int result;
    // static int[][] memo;
    static Point[] x;
    static Point[] y;
    static Point[] z;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        // memo = new int[N][3];
        x = new Point[N];
        y = new Point[N];
        z = new Point[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            x[i] = new Point(i, a);
            int b = Integer.parseInt(st.nextToken());
            y[i] = new Point(i, b);
            int c = Integer.parseInt(st.nextToken());
            z[i] = new Point(i, c);
        }
        Arrays.sort(x);
        Arrays.sort(y);
        Arrays.sort(z);
        for (Point point : x) {
            System.out.println(point);
        }
    }
}
