package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_회전초밥v2 {
    static int N, d, k, c;
    static int[] paper;
    static int[] check;
    static int result;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        paper = new int[N];
        check = new int[d + 1];

        for (int i = 0; i < k; i++) {
            paper[i] = Integer.parseInt(br.readLine());
            if (check[paper[i]]++ == 0) {
                cnt++;
            }
        }
        for (int i = k; i < N; i++) {
            paper[i] = Integer.parseInt(br.readLine());
        }
        result = (check[c] == 0) ? cnt + 1 : cnt;

        for (int left = 1; left < N; left++, k++) {
            
            if (--check[paper[(left - 1) % N]] == 0)
                cnt--;

            if (check[paper[k % N]]++ == 0)
                cnt++;

            result = Math.max(result, (check[c] == 0) ? cnt + 1 : cnt);
        }

        System.out.println(result);
    }
}
