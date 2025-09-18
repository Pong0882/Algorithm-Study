package baekjoon_v2.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_지름길 {
    static class Edge {
        int e, w;

        Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }

    static final int INF = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] paper = new int[D + 1];

        List<Edge>[] shortcut = new ArrayList[D + 1];
        for (int i = 0; i < D + 1; i++) {
            shortcut[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (s < 0 || s > D)
                continue;
            if (e < 0 || e > D)
                continue;
            if (w >= e - s)
                continue;
            shortcut[s].add(new Edge(e, w));
        }

        Arrays.fill(paper, INF);
        paper[0] = 0;

        for (int i = 0; i < D; i++) {
            paper[i + 1] = Math.min(paper[i + 1], paper[i] + 1);
            for (Edge edge : shortcut[i]) {
                paper[edge.e] = Math.min(paper[edge.e], paper[i] + edge.w);
            }
        }
        System.out.println(paper[D]);
    }
}
