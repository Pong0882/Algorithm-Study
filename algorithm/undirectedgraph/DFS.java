package algorithm.undirectedgraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 무방향 그래프 >> ArrayList<>[] 이용하여 DFS 사용하기
public class DFS {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int A, B, N, M, result;
    private static int[][] paper;

    // DFS로 풀어보기
    // 이후 BFS, union-find ( Dishoint Set )공부해서 풀어보기

    // ArrayList 배열을 이용해본다.

    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        } // 각 node 값마다 Integer를 담는 ArrayList<> 배열을 graph에 각각 생성하기

        for (int i = 0; i < M; i++) { // 선 입력 수만큼 반복해서 선 그어줄것
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            // 무방향 그래프라 양쪽을 넣어줌
            graph[A].add(B);
            graph[B].add(A);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {// 하나씩 일단 확인해서 한번도 안들어간 노드 있으면 들어가서 빙글빙글~
                dfs(i);
                // 새로운곳 DFS 들어갈때마다 result 값을 키워주자..
                result++;
            }
        }
        System.out.println(result);
    }

    private static void dfs(int i) {
        // 일단 들어왔으면 들어왔다고 말해줘
        visited[i] = true;

        for (int next : graph[i]) {
            // 들어온 노드기준으로 foreach 반복문 돌아주면서 갈수있는거 DFS 계속해줌

            if (!visited[next]) {
                // 만약 방문안했으면 들어가!
                dfs(next);
            }
        }
    }
}
