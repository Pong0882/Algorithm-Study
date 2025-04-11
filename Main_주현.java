import java.util.*;
import java.io.*;

public class Main_주현 {
    public static void main(String[] args) throws Exception {

        // 입력받기
        BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(brr.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(brr.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] ar = { { 0, 0, 0 }, { 1, 2, 3 } };
        int[][] ac = { { 1, 2, 3 }, { 0, 0, 0 } };

        int[][] br = { { 0, 1, 1 } };
        int[][] bc = { { 1, 0, 1 } };

        int[][] cr = { { -1, -2, -2 }, { -1, -2, -2 }, { 0, 0, -1 }, { 0, 0, 1 }, { 1, 2, 2 }, { 1, 2, 2 }, { 0, 0, 1 },
                { 0, 0, -1 } };
        int[][] cc = { { 0, 0, -1 }, { 0, 0, 1 }, { 1, 2, 2 }, { 1, 2, 2 }, { 0, 0, 1 }, { 0, 0, -1 }, { -1, -2, -2 },
                { -1, -2, -2 } };

        int[][] dr = { { -1, -1, -2 }, { -1, -1, -2 }, { 0, -1, -1 }, { 0, 1, 1 } };
        int[][] dc = { { 0, -1, -1 }, { 0, 1, 1 }, { 1, 1, 2 }, { 1, 1, 2 } };

        int[][] er = { { -1, -1, -2 }, { 0, 1, 0 }, { 1, 1, 2 }, { 0, -1, 0 } };
        int[][] ec = { { 0, 1, 0 }, { 1, 1, 2 }, { 0, -1, 0 }, { -1, -1, -2 } };

        int[] shape = { 2, 1, 8, 4, 4 };

        int[][][] rrr = { ar, br, cr, dr, er };
        int[][][] ccc = { ac, bc, cc, dc, ec };
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < shape[k]; l++) {
                        int t = map[i][j];
                        boolean flag = true;
                        for (int p = 0; p < 3; p++) {
                            int r = i + rrr[k][l][p];
                            int c = j + ccc[k][l][p];
                            if (r < 0 || c < 0 || r >= n || c >= m) {
                                flag = false;
                                break;
                            }
                            t += map[r][c];
                        }
                        if (flag)
                            ans = Math.max(ans, t);
                    }
                }
            }
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();

    }
}
