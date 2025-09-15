package baekjoon_v2.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main_카드2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int i = 1; i < N + 1; i++) {
            q.add(i);
        }

        while (q.size() != 1) {
            q.poll();
            q.add(q.poll());
        }

        System.out.println(q.poll());
    }
}
