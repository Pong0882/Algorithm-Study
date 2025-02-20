package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_puyopuyo {
    static int N, M;
    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };
    static int puyoCnt;
    static int result;
    static char[][] paper;
    static LinkedList<Character>[] map;
    static boolean[][] visited;
    static boolean pop;
    // private static class node {
    // int r, c, value;

    // public node(int r, int c, int value) {
    // this.r = r;
    // this.c = c;
    // this.value = value;
    // }
    // }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = 12;
        M = 6;
        paper = new char[N][M];
        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                paper[i][j] = c[j];
            }
        }
        map = new LinkedList[M];
        for (int i = 0; i < M; i++) {
            map[i] = new LinkedList<>();
        }
        for (int i = 0; i < M; i++) {
            for (int j = N - 1; j >= 0; j--) {
                // System.out.println("o");
                if (paper[j][i] != '.') {
                    map[i].add(paper[j][i]);
                }
            }
        }
        GameStart();
        // System.out.println(map[0].get(1));

        System.out.println(puyoCnt);
    }

    private static void GameStart() {
        while (true) {
            pop = false;
            visited = new boolean[M][N];
            List<Integer[]> puyo = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < map[i].size(); j++) {
                    if (visited[i][j] == true) {
                        continue;
                    } // 한번 끊어
                    Queue<Integer[]> queue = new ArrayDeque<>();
                    List<Integer[]> puyoTmp = new ArrayList<>();
                    queue.add(new Integer[] { i, j });
                    puyoTmp.add(new Integer[] { i, j });
                    visited[i][j] = true;
                    // System.out.println("Hello");
                    while (!queue.isEmpty()) {
                        Integer[] tmp = queue.poll();
                        int r = tmp[0];
                        int c = tmp[1];
                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if (!check(nr, nc)) {
                                continue;
                            }
                            if (visited[nr][nc] == true) {
                                continue;
                            }
                            if (map[r].get(c) == map[nr].get(nc)) { // 전꺼랑 똑같으면 넣어
                                visited[nr][nc] = true;
                                queue.add(new Integer[] { nr, nc });
                                puyoTmp.add(new Integer[] { nr, nc });
                                // System.out.println(nr + " " + nc);
                            }
                        }
                    }
                    if (puyoTmp.size() >= 4) {
                        for (int j2 = 0; j2 < puyoTmp.size(); j2++) {
                            puyo.add(puyoTmp.get(j2));
                        }
                    }
                }
            }
            if (puyo.size() >= 4) { // 뿌요!!
                Collections.sort(puyo, (a, b) -> b[1] - a[1]);
                // System.out.print(puyo.get(0)[0] + " " + puyo.size());
                // System.out.println();
                for (int k = 0; k < puyo.size(); k++) {
                    Integer[] tmp = puyo.get(k);
                    int r = tmp[0];
                    int c = tmp[1];
                    map[r].remove(c);
                }
                pop = true;
            }
            // for (int z = 0; z < M; z++) {
            // System.out.println(map[z]);
            // }
            // System.out.println(puyoCnt);
            // System.out.println(puyoCnt);
            if (!pop) {
                return;
            }
            puyoCnt++;
        }
    }

    private static boolean check(int r, int c) {
        return r >= 0 && c >= 0 && r < M && c < map[r].size();
    }
}
