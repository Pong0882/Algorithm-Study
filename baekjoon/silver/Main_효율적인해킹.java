package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_효율적인해킹 {
    private static int N, M;
    private static List<Integer>[] list;

    private static int[] result;
    // private static boolean[] visited;
    private static int[] visited;

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

            list[b].add(a);
        }

        result = new int[N + 1];
        visited = new int[N + 1];
        int max = 0;
        // Queue를 사용할때 LinkedList와 ArrayDeque의 차이점 확인

        for (int i = 1; i < N + 1; i++) {
            if (list[i].isEmpty()) {
                continue;
            }
            ////////////////////////////////////////
            Queue<Integer> que = new ArrayDeque<>();

            visited[i] = i; // 방문 체크
            int cnt = 0; // 얼마나 들어가나 셀꺼야

            // for (int j = 0; j < list[i].size(); j++) {
            // int tmp = list[i].get(j);
            // que.offer(tmp);
            // // 여기서 que 넣으면 어차피 갈녀석이잖아?!
            // visited[tmp] = i;
            // cnt++;
            // } // 처음 들어가는애가 갈수있는거 다넣어
            que.offer(i);
            while (!que.isEmpty()) {
                // int next = que.poll();
                // if (visited[next] == true)
                // continue; // 방문했었으면 돌아가

                // if (result[next] != 0) {
                // cnt += result[next];
                // } // 아니 이거 이러다가 짧은 루트있으면 망 아닌가?
                int cur = que.poll();
                // 향상된 for문 대신 일반 for문을 사용하여 약간의 오버헤드를 줄일 수 있음
                for (int j = 0, size = list[cur].size(); j < size; j++) {
                    int next = list[cur].get(j);
                    if (visited[next] != i) {
                        visited[next] = i;
                        que.offer(next);
                        cnt++;
                    }
                }
                // for (int rsc : list[next]) {
                // if (visited[rsc] != i) {
                // que.offer(rsc);
                // visited[rsc] = i;
                // cnt++;
                // } // 방문한적 없는애들만 que에 넣을께
                // }
            }
            result[i] = cnt;
            max = Math.max(max, cnt);
        }

        // System.out.println(Arrays.toString(result));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (result[i] == max) {
                sb.append(i).append(" ");
                // 출력 잘보자
            }
        }
        System.out.println(sb);
    }
}
