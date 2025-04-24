import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] indeg;
    static int[] result;
    static int N, M;

    static ArrayList<Integer>[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        indeg = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            indeg[b]++;
            lists[a].add(b);
        }

        result = new int[N + 1];
        int time = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            if (indeg[i] == 0) {
                q.add(i);
                // result[i] = time;
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            for (int i = 0; i < size; i++) {
                Integer tmp = q.poll();
                result[tmp] = time;
                for (Integer next : lists[tmp]) {
                    if (--indeg[next] == 0) {
                        q.add(next);
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(result));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}
