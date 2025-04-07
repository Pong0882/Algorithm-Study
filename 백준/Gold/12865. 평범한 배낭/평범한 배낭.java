import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        // sb.append(i).append(' ');

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int bag = Integer.parseInt(st.nextToken());

        int[] size = new int[n + 1];
        int[] value = new int[n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            size[i + 1] = Integer.parseInt(st.nextToken());
            value[i + 1] = Integer.parseInt(st.nextToken());
        }
        ////////////////////////////////////////////////////////

        int[][] culc = new int[n + 1][bag + 1];
        int tmp = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= bag; j++) {
                if (j - size[i] >= 0) {
                    culc[i][j] = Math.max(value[i] + culc[i - 1][j - size[i]], culc[i - 1][j]);
                } else {
                    culc[i][j] = culc[i - 1][j];
                }
            }
        }
        System.out.println(culc[n][bag]);
    };
}
