package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_행성터널 {
    static class Edge implements Comparable<Edge> {
        int s,e, w;


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

    static class Point implements Comparable<Point> {
        @Override
        public String toString() {
            return "Point [idx=" + idx + ", value=" + value + "]";
        }

        int idx, value;

        public Point(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(value, o.value);
        }
    }

    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static boolean[] visited;
    static int result;
    static Point[] x;
    static Point[] y;
    static Point[] z;
    static int[][] paper;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        x = new Point[N];
        y = new Point[N];
        z = new Point[N];
        // paper = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int xx = Integer.parseInt(st.nextToken());
            int yy = Integer.parseInt(st.nextToken());
            int zz = Integer.parseInt(st.nextToken());
            // paper[i][0] = xx;
            // paper[i][1] = yy;
            // paper[i][2] = zz;
            x[i] = new Point(i, xx);
            y[i] = new Point(i, yy);
            z[i] = new Point(i, zz);
        }
        Arrays.sort(x);
        Arrays.sort(y);
        Arrays.sort(z);
        for (int i = 0; i < N; i++) {
            System.out.print(x[i]);
            System.out.print(y[i]);
            System.out.println(z[i]);
        }

        for (int i = 0; i < N; i++) {
            int index = x[i].idx;
            
        }

    }
}
