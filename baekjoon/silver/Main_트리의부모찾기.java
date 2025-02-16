package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_트리의부모찾기 {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static boolean[] visited;
    private static int[] parent;
    private static List<Integer>[] con;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        visited[1] = true;
        parent = new int[N + 1];
        con = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            con[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            con[a].add(b);
            con[b].add(a);
        }

        // bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int par = queue.poll();
            for (int i = 0; i < con[par].size(); i++) {
                int tmp = con[par].get(i);
                if (visited[tmp]) {
                    continue;
                }
                visited[tmp] = true;
                parent[tmp] = par;
                queue.add(tmp);
            }
        }

        for (int i = 1; i < N + 1; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }
}
