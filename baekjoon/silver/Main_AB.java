package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_AB {
    static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        ArrayDeque<int[]> q = new ArrayDeque<>();

        q.add(new int[] { A, 1 });
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int cur = tmp[0];
            int time = tmp[1];

            if (cur == B) {
                System.out.println(time);
                return;
            }

            long next = (long) cur * 2;
            if (next <= B) {
                q.add(new int[] { cur * 2, time + 1 });

            }
            next = (long) cur * 10 + 1;
            if (next <= B) {
                q.add(new int[] { cur * 10 + 1, time + 1 });
            }
        }
        System.out.println(-1);
    }
}
