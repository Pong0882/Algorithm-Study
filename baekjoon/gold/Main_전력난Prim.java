package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_전력난Prim {
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

    static int result;
    static int max;
    static PriorityQueue<Edge> point;
    static ArrayList<Edge>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }
            list = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                list[i] = new ArrayList<>();
            }

            point = new PriorityQueue<>();
            max = 0;
            result = 0;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                max += w;
                list[s].add(new Edge(e, w));
                list[e].add(new Edge(s, w));
            }
            visited = new boolean[n];
            point.add(new Edge(0, 0));
            int cnt = 0;
            while (!point.isEmpty() && cnt != n) {
                Edge tmp = point.poll();
                if (visited[tmp.e]) {
                    continue;
                }
                // System.out.println(tmp.e + " " + tmp.w);
                // System.out.println();
                // System.out.println(result + " " + cnt);
                visited[tmp.e] = true;
                cnt++;
                result += tmp.w;

                for (Edge next : list[tmp.e]) {
                    if (visited[next.e]) {
                        continue;
                    }
                    point.add(next);
                }
            }
            System.out.println(max - result);
        }
    }
}
