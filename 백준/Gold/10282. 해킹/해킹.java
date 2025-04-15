import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int T;

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

    static ArrayList<Edge>[] list;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            list = new ArrayList[N + 1];
            for (int i = 0; i < N + 1; i++) {
                list[i] = new ArrayList<>();
            }
            result = new int[N + 1];
            Arrays.fill(result, Integer.MAX_VALUE);
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                int b = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                list[a].add(new Edge(b, w));
            }

            result[start] = 0;
            pq.add(new Edge(start, 0));

            while (!pq.isEmpty()) {
                Edge tmp = pq.poll();
                // System.out.println("hello?");
                if (result[tmp.e] < tmp.w) {
                    continue;
                }
                for (Edge next : list[tmp.e]) {
                    int nextValue = next.w + result[tmp.e];
                    if (result[next.e] > nextValue) {
                        pq.add(next);
                        result[next.e] = nextValue;
                    }
                }
            }
            // System.out.println(Arrays.toString(result));
            int sol = 0;
            int max = 0;
            for (int i = 0; i < N; i++) {
                if (result[i + 1] != Integer.MAX_VALUE) {
                    sol++;
                    max = Math.max(max, result[i + 1]);
                }
            }
            // System.out.println(sol + " " + max);
            sb.append(sol).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
