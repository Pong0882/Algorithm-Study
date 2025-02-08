package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_효율적인해킹v2 {
    private static int N, M;
    private static List<Integer>[] list;

    private static int[] result;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }

        result = new int[N + 1];
        int max = 0;

        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1];
            dfs(i);
            max = Math.max(max, result[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (result[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        for (int next : list[cur]) {
            if (!visited[next]) {
                result[next]++;
                dfs(next);
            }
        }
    }
}
