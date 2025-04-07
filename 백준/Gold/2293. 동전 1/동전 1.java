import java.io.*;
import java.util.*;

public class Main {
    private static int[] data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        data = new int[k + 1];
        data[0] = 1;
        for (int re = 0; re < n; re++) {
            int coin = Integer.parseInt(br.readLine());

            for (int i = 1; i <= k; i++) {
                if (i >= coin) {
                    data[i] += data[i - coin];
                }
            }
        }
        System.out.println(data[k]);
    };
}
