package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
<<<<<<< HEAD
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
=======
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
>>>>>>> 78c52dc907d0e79fe799f26f53aabddbfb8251f0
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_행성터널 {
    static class Edge implements Comparable<Edge> {
<<<<<<< HEAD
        int e, w;

        public Edge(int e, int w) {
=======
        int s,e, w;


        public Edge(int s, int e, int w) {
            this.s = s;
>>>>>>> 78c52dc907d0e79fe799f26f53aabddbfb8251f0
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(w, o.w);
        }
    }

<<<<<<< HEAD
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
=======
    static class Point implements Comparable<Point> {
        @Override
        public String toString() {
            return "Point [idx=" + idx + ", value=" + value + "]";
        }

        int idx, value;

        public Point(int idx, int value) {
            this.idx = idx;
            this.value = value;
>>>>>>> 78c52dc907d0e79fe799f26f53aabddbfb8251f0
        }

        @Override
        public int compareTo(Point o) {
<<<<<<< HEAD
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
=======
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
>>>>>>> 78c52dc907d0e79fe799f26f53aabddbfb8251f0

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        // memo = new int[N][3];
        x = new Point[N];
        y = new Point[N];
        z = new Point[N];

<<<<<<< HEAD
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            x[i] = new Point(i, a);
            int b = Integer.parseInt(st.nextToken());
            y[i] = new Point(i, b);
            int c = Integer.parseInt(st.nextToken());
            z[i] = new Point(i, c);
=======
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
>>>>>>> 78c52dc907d0e79fe799f26f53aabddbfb8251f0
        }
        Arrays.sort(x);
        Arrays.sort(y);
        Arrays.sort(z);
<<<<<<< HEAD
        for (Point point : x) {
            System.out.println(point);
        }
=======
        for (int i = 0; i < N; i++) {
            System.out.print(x[i]);
            System.out.print(y[i]);
            System.out.println(z[i]);
        }

        for (int i = 0; i < N; i++) {
            int index = x[i].idx;
            
        }

>>>>>>> 78c52dc907d0e79fe799f26f53aabddbfb8251f0
    }
}
