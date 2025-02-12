package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_게리맨더링 {
    private static int N;
    private static int[][] paper;
    private static int[] value;
    private static boolean[] visited;
    private static boolean[] select;

    private static int resultMinDiff = 10000000;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        paper = new int[N + 1][N + 1];
        value = new int[N + 1];
        select = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= tmp; j++) {
                int gatetmp = Integer.parseInt(st.nextToken());
                paper[i][gatetmp] = 1;
            }
        }

        subset(1);

        // for (int i = 0; i <= N; i++) {
        // System.out.println(Arrays.toString(paper[i]));
        // }
        System.out.println(resultMinDiff == 10000000 ? -1 : resultMinDiff);
    }

    private static void subset(int cnt) {
        if (cnt > N) {
            // 여기서 select 값들끼리 연결되었는지 확인하고, 값비교
            makeTeam();
            return;
        }
        select[cnt] = true;
        subset(cnt + 1);
        select[cnt] = false;
        subset(cnt + 1);
    }

    private static void makeTeam() {
        List<Integer> trueTeam = new ArrayList<>();
        List<Integer> falseTeam = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (select[i]) {
                trueTeam.add(i);
            } else {
                falseTeam.add(i);
            }
        }
        if (trueTeam.isEmpty() || trueTeam.size() == N) {
            return;
        }

        if (inConnected(trueTeam) && inConnected(falseTeam)) {
            int sumA = 0;
            int sumB = 0;
            for (int num : trueTeam) {
                sumA += value[num];
            }
            for (int num : falseTeam) {
                sumB += value[num];
            }
            resultMinDiff = Math.min(resultMinDiff, Math.abs(sumA - sumB));
            // System.out.println(resultMinDiff);
        }
    }

    private static boolean inConnected(List<Integer> group) {
        visited = new boolean[N + 1];
        Queue<Integer> que = new LinkedList<>();

        que.add(group.get(0));
        visited[group.get(0)] = true;
        int count = 1;

        while (!que.isEmpty()) {
            int node = que.poll();
            for (int i = 1; i <= N; i++) {
                if (paper[node][i] == 1 && !visited[i] && group.contains(i)) {
                    visited[i] = true;
                    que.add(i);
                    count++;
                }
            }
        }
        return count == group.size();
    }
}
