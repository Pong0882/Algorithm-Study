package baekjoon_v2.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_햄버거분배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String S = br.readLine();

        ArrayList<Integer> H = new ArrayList<>();
        ArrayList<Integer> P = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char tmp = S.charAt(i);
            if (tmp == 'H') {
                H.add(i);
            } else {
                P.add(i);
            }
        }
        int result = 0;

        int h = 0;
        int p = 0;

        while (h < H.size() && p < P.size()) {
            int cal = Math.abs(H.get(h) - P.get(p));
            if (cal <= K) {
                result++;
                p++;
                h++;
            } else if (H.get(h) < P.get(p) - K) {
                h++;
            } else {
                p++;
            }
        }
        System.out.println(result);
    }
}