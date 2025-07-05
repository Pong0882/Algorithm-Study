package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_피리부는사나이UnionFind {
    static int N, M;
    static int[][] map;
    static int[] parent;
    static int result;

    static int[] dr = { -1, 0, 1, 0 }; // U R D L
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        parent = new int[N * M];

        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                switch (tmp[j]) {
                    case 'U':
                        map[i][j] = 0;
                        break;
                    case 'R':
                        map[i][j] = 1;
                        break;
                    case 'D':
                        map[i][j] = 2;
                        break;
                    case 'L':
                        map[i][j] = 3;
                        break;
                }
            }
        }

        // parent 초기화
        for (int i = 0; i < N * M; i++) {
            parent[i] = i;
        }

        // 유니온 수행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int dir = map[i][j];
                int ni = i + dr[dir];
                int nj = j + dc[dir];

                int cur = i * M + j;
                int next = ni * M + nj;

                union(cur, next);
            }
        }

        // 싸이클(안전영역) 개수 세기
        for (int i = 0; i < N * M; i++) {
            if (parent[i] == i) {
                result++;
            }
        }

        System.out.println(result);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 경로 압축
        }
        return parent[x];
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa != pb) {
            parent[pa] = pb;
        }
    }
}
