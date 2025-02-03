package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int A, B, N, M, result;
    private static int[][] paper;
    private static int[] dx = { 0, 1, 0, -1 };
    private static int[] dy = { 1, 0, -1, 0 };
    private static int cnt;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        List<Integer> save = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                paper[i][j] = c[j] - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (paper[i][j] == 1) {
                    cnt++;
                    result = 1;
                    bfs(i, j, cnt + 1);
                    save.add(result);
                }
            }
        }
        // for (int i = 0; i < N; i++) {
        // System.out.println(Arrays.toString(paper[i]));
        // }
        Collections.sort(save);

        System.out.println(cnt);
        for (int i = 0; i < save.size(); i++) {
            System.out.println(save.get(i));
        }
    }

    private static void bfs(int cx, int cy, int group) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] { cx, cy });
        paper[cx][cy] = group;
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!outCheck(nx, ny)) {
                    continue;
                }
                if (paper[nx][ny] == 1) {
                    que.offer(new int[] { nx, ny });
                    result++;
                    paper[nx][ny] = group;
                }
            }
        }
    }

    private static boolean outCheck(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
