package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_인구이동 {
    static int N, L, R;
    static int[][] paper;
    static int day, min, country;
    static int[][] visited;
    static int[] dr = { 1, 0, -1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        paper = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move();
        System.out.println(day);
    }

    private static void move() {
        while (true) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] <= min) {
                        // System.out.println(country + " " + min);
                        // for (int k = 0; k < N; k++) {
                        // System.out.println(Arrays.toString(visited[k]));
                        // }
                        // System.out.println(i + " " + j);
                        int tmpSum = 0;
                        country++; // 이걸로 구분할거
                        if (country == min + (N * N)) {
                            return;
                        }
                        ArrayDeque<Integer[]> queue = new ArrayDeque<>();
                        List<Integer[]> countryQue = new ArrayList<>();
                        visited[i][j] = country;
                        queue.add(new Integer[] { i, j });
                        while (!queue.isEmpty()) {
                            Integer[] tmp = queue.poll();
                            int r = tmp[0];
                            int c = tmp[1];
                            countryQue.add(new Integer[] { r, c }); // 추가해둬..
                            tmpSum += paper[r][c];
                            for (int k = 0; k < 4; k++) {
                                int nr = r + dr[k];
                                int nc = c + dc[k];
                                if (!check(nr, nc)) {
                                    continue;
                                }
                                if (manDiffcheck(r, c, nr, nc) && visited[nr][nc] <= min) {
                                    // System.out.print(nr + " " + nc + " / ");
                                    queue.add(new Integer[] { nr, nc });
                                    visited[nr][nc] = country;
                                }
                            }
                        }

                        // for (int z = 0; z < N; z++) {
                        // System.out.println(Arrays.toString(paper[z]));
                        // }
                        // System.out.println();
                        // System.out.println(countryQue.size());
                        // if (countryQue.size() == N * N) {
                        // day++;
                        // return;
                        // }
                        for (int k = 0; k < countryQue.size(); k++) { // countryQue 사용
                            Integer[] tmp = countryQue.get(k);
                            int r = tmp[0];
                            int c = tmp[1];
                            paper[r][c] = tmpSum / countryQue.size();
                        }
                    }
                }
            }
            // System.out.println(min + " " + country);
            if (min == country) {
                return;
            }
            min = country;
            day++;

        }
    }

    private static boolean manDiffcheck(int r, int c, int nr, int nc) {
        int diff = Math.abs(paper[r][c] - paper[nr][nc]);
        return diff >= L && diff <= R;
    }

    private static boolean check(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
