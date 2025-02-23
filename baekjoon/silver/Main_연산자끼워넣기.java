package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_연산자끼워넣기 {
    static int N;
    static int[] oper;
    static int[] nums;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[] select;
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        oper = new int[N - 1];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        select = new int[N - 1];
        visited = new boolean[N - 1];
        st = new StringTokenizer(br.readLine());
        int opercnt = 1;
        int index = 0;
        for (int i = 0; i < 4; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            for (int j = 0; j < tmp; j++) {
                oper[index++] = opercnt;
            }
            opercnt++;
        }
        // System.out.println(Arrays.toString(oper));

        Perm(0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void Perm(int cnt) {
        if (cnt == N - 1) {
            // System.out.println(Arrays.toString(select));
            oper();
            return;
        }
        for (int i = 0; i < N - 1; i++) {
            if (visited[i] == true)
                continue;
            select[cnt] = oper[i];
            visited[i] = true;
            Perm(cnt + 1);
            visited[i] = false;
        }
    }

    private static void oper() {
        ArrayDeque<Integer> stack = new ArrayDeque();
        stack.push(nums[0]);
        for (int i = 1; i < N; i++) {
            switch (select[i - 1]) {
                case 1:
                    stack.push(nums[i]);
                    break;
                case 2:
                    stack.push(-1 * nums[i]);
                    break;
                case 3:
                    stack.push(stack.pop() * nums[i]);
                    break;
                case 4:
                    stack.push(stack.pop() / nums[i]);
                    break;
                default:
                    break;
            }
        }
        // System.out.println(stack);
        int result = stack.pop();
        for (int num : stack) {
            result += num;
        }
        // if (min > result) {
        // System.out.println(result);
        // System.out.println(min + " " + max);
        // System.out.println();
        // System.out.println(Arrays.toString(nums));
        // System.out.println(Arrays.toString(select));
        // }
        min = Math.min(result, min);
        max = Math.max(result, max);
    }
}
