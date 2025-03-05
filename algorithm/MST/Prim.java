package algorithm.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Lollipop implements Comparable<Lollipop> {
    int end, w;

    public Lollipop(int v, int w) {
        this.end = v;
        this.w = w;
    }

    @Override
    public int compareTo(Lollipop o) {
        return Integer.compare(this.w, o.w);
    }
}

public class Prim {
    static int N, L;
    static PriorityQueue<Lollipop> lines;
    static int min;
    static boolean[] visited;
    static List<Lollipop>[] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        node = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            node[i] = new ArrayList<>();
        }
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            node[s].add(new Lollipop(e, w));
            node[e].add(new Lollipop(s, w));
        }
        prim();
        System.out.println(min);
    }

    private static void prim() {
        visited = new boolean[N + 1];
        lines = new PriorityQueue<>();
        lines.add(new Lollipop(1, 0));
        int ConnCnt = 0;
        while (!lines.isEmpty()) {
            Lollipop cheapLine = lines.poll();
            if (visited[cheapLine.end]) {
                continue;
            }
            min += cheapLine.w;
            visited[cheapLine.end] = true;
            if (N == ++ConnCnt)
                return;
            for (int i = 0; i < node[cheapLine.end].size(); i++) {
                Lollipop next = node[cheapLine.end].get(i);
                if (visited[next.end])
                    continue;
                lines.add(next);
            }
        }
        return;
    }
}
