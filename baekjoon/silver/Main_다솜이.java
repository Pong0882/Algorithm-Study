package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_다솜이 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> ism = new HashMap<>();
        Map<String, Integer> sim = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            ism.put(i, s);

            sim.put(s, i);
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            int tmp = s.charAt(0);
            if (tmp < 'A') {
                sb.append(ism.get(Integer.parseInt(s) - 1)).append("\n");
            } else {
                sb.append(sim.get(s) + 1).append("\n");
            }
        }
        System.out.println(sb);
    }
}