package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_햄버거다이어트 {
    private static int N, L;
    // private static int[] select;
    private static int[][] material;
    private static int resultMaxValue;
    private static boolean[] select;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int Tcase = 1; Tcase <= T; Tcase++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            resultMaxValue = 0;
            material = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                material[i][0] = Integer.parseInt(st.nextToken());
                material[i][1] = Integer.parseInt(st.nextToken());
            }

            select = new boolean[N];
            // combi로 [][1]각각 뽑아서 1000 넘는지 확인하고 안넘으면
            // [][0]값 더해서 resultMaxValue 로 갱신

            // 엥 combi가 아니라 subset 해야겠는데데
            subset(0);
            sb.append("#").append(Tcase).append(" ").append(resultMaxValue).append("\n");

        }
        System.out.println(sb);

    }

    private static void subset(int cnt) {
        if (cnt == N) {
            // 뽑은애들의 칼로리 확인
            if (!calCheck())
                return;
            return;
        }

        select[cnt] = true;
        subset(cnt + 1);
        select[cnt] = false;
        subset(cnt + 1);
    }

    private static boolean calCheck() {
        int sumCal = 0;
        int resultTmp = 0;
        for (int i = 0; i < N; i++) {
            if (select[i] == true) {
                sumCal += material[i][1];
                resultTmp += material[i][0];
            }
            if (sumCal > L) {
                return false;
            }
        }
        resultMaxValue = Math.max(resultMaxValue, resultTmp);
        return true;
    }
}
