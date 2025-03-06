package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Conn implements Comparable<Conn> {
    int v, w;

    public Conn(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Conn o) {
        return Integer.compare(this.w, o.w);
    }

}

public class Main_최소스패닝트리prim2 {
    static int min;
    static PriorityQueue<Conn> ConnPQ;
    static boolean[] visited;
    static ArrayList<Conn>[] node;
    static int edge, vertex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        node = new ArrayList[vertex + 1];
        for (int i = 0; i < edge + 1; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            node[s].add(new Conn(e, w));
            node[e].add(new Conn(s, w));
        }
        Prim();
    }

    private static void Prim() {
        visited = new boolean[vertex + 1];
        ConnPQ = new PriorityQueue<>();
        ConnPQ.add(new Conn(1, 0));
        int ConnCnt = 0;
        while (!ConnPQ.isEmpty()) {
            Conn tmp = ConnPQ.poll();
            int v = tmp.v;
            int w = tmp.w;
            if (visited[v]) {
                continue;
            }
            visited[v] = true;
            min += w;
            if (++ConnCnt == vertex) {
                return; // 최소 스패닝 트리 완성!
            }
            // 이제 새로운 노드에 달려있던 인접노드들을 PQ에 넣어줘
            for (int i = 0; i < node[v].size(); i++) {
                Conn nextConn = node[v].get(i);
                if (visited[nextConn.v]) {
                    continue;
                }
                ConnPQ.add(nextConn);
            }
        }
        return;
    }
}
