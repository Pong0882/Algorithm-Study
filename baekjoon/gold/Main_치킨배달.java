package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Priority Queue 쓸수 없을까?
// 정렬할때 그럼 치킨집 번호도 가져가야해..
// <집번호, <치킨집번호, 거리>> 형태의 맵??
// 집번호에서 정렬할때 그럼 거리 기준으로 정리하라고 알려줘야겠네?
// 아 머리야
public class Main_치킨배달 {
    private static int N, M;
    private static int[][] chickenDistance;
    private static List<int[]> homeList = new ArrayList<>();
    private static List<int[]> chickenList = new ArrayList<>();
    private static int[] select;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = Integer.MAX_VALUE;
        chickenDistance = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    homeList.add(new int[] { i, j });
                }
                if (tmp == 2) {
                    chickenList.add(new int[] { i, j });
                }
            }
        }
        chickenDistance = new int[chickenList.size()][homeList.size()];
        for (int i = 0; i < chickenList.size(); i++) {
            int[] curChicken = chickenList.get(i);
            for (int j = 0; j < homeList.size(); j++) {
                int[] curHome = homeList.get(j);
                chickenDistance[i][j] = Math.abs(curChicken[0] - curHome[0]) + Math.abs(curChicken[1] - curHome[1]);
            }
        }

        select = new int[M];
        combiChicken(0, 0);

        // for (int i = 0; i < chickenList.size(); i++) {
        // System.out.println(Arrays.toString(chickenDistance[i]));
        // }
        System.out.println(result);
    }

    private static void combiChicken(int start, int cnt) {
        if (cnt == M) {
            int tmp = sumChickenDistance();
            result = Math.min(result, tmp);
            // System.out.println(Arrays.toString(select));
            return;
        }

        for (int i = start; i < chickenList.size(); i++) {
            select[cnt] = i;
            combiChicken(i + 1, cnt + 1);
        }

    }

    private static int sumChickenDistance() {
        int sumMinResult = 0;
        for (int i = 0; i < homeList.size(); i++) {
            int minTmp = Integer.MAX_VALUE;
            for (int idx : select) {
                minTmp = Math.min(chickenDistance[idx][i], minTmp);
            }
            sumMinResult += minTmp;
        }
        return sumMinResult;
    }
}
