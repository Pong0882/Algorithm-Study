package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Conn implements Comparable<Conn> {
    int v;
    double w;

    @Override
    public String toString() {
        return "Conn [v=" + v + ", w=" + w + "]";
    }

    public Conn(int v, double w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Conn o) {
        return Double.compare(this.w, o.w);
    }
}

public class Main_별자리만들기 {
    static int n;
    static double[][] data;
    static PriorityQueue<Conn> ConnPQ = new PriorityQueue<>();
    static ArrayList<Conn>[] node;
    static double result;
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        data = new double[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Double.parseDouble(st.nextToken());
            data[i][1] = Double.parseDouble(st.nextToken());
        }
        node = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double w = Math.sqrt(
                        Math.pow(Math.abs(data[i][0] - data[j][0]), 2)
                                + Math.pow(Math.abs(data[i][1] - data[j][1]), 2));
                node[i].add(new Conn(j, w));
                node[j].add(new Conn(i, w));
            }
        }

        Prim();
        // for (int i = 0; i < n; i++) {
        // for (Conn a : node[i]) {
        // System.out.println(i + " >> " + a);
        // }
        // }
        System.out.println(result);
    }

    private static void Prim() {
        visited = new boolean[n];
        ConnPQ.add(new Conn(0, 0));
        int cnt = 0;
        while (!ConnPQ.isEmpty()) {
            // System.out.println(cnt);
            Conn tmp = ConnPQ.poll();
            int v = tmp.v;
            double w = tmp.w;
            if (visited[v]) {
                continue;
            }
            visited[v] = true;
            result += w;
            if (++cnt == n) {
                return;
            }
            for (Conn nextConn : node[v]) {
                if (!visited[nextConn.v]) {
                    ConnPQ.add(new Conn(nextConn.v, nextConn.w)); // ✅ 새 객체로 넣어서 힙 크기 줄이기
                }
            }
        }
        return;
    }
}
