package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_숨바꼭질4 {
    static int start, end;
    static int[] paper;
    static int MAX = 100001;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        paper = new int[MAX];
        Arrays.fill(paper, -1);

        paper[start] = start;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        while (true) {
            int tmp = queue.poll();
            // -1 , +1, *2 로 bfs 돌리자
            if (tmp == end)
                break;

            int next;

            // 1 번 상황
            next = tmp + 1;
            if (check(next) && paper[next] == -1) {
                queue.add(next);
                paper[next] = tmp;
            }
            // 2번 상황
            next = tmp - 1;
            if (check(next) && paper[next] == -1) {
                queue.add(next);
                paper[next] = tmp;
            }
            // 3번상황
            next = tmp * 2;
            if (check(next) && paper[next] == -1) {
                queue.add(next);
                paper[next] = tmp;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(end);
        int idx = 0;
        while (true) {
            int tmp = result.get(idx++);
            if (tmp == start) {
                break;
            }
            result.add(paper[tmp]);
        }
        sb.append(result.size() - 1).append("\n");
        for (int i = result.size() - 1; i >= 0; i--) {
            sb.append(result.get(i)).append(" ");
        }
        System.out.println(sb);
    }

    private static boolean check(int n) {
        return n >= 0 && n < MAX;
    }
}
