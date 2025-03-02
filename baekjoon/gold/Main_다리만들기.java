package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    public Edge(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

    int s, e, w;

    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }

}

class LandPair {
    int land1;
    int land2;

    public LandPair(int a, int b) {
        // 항상 작은 값이 먼저 오도록 정렬
        if (a < b) {
            this.land1 = a;
            this.land2 = b;
        } else {
            this.land1 = b;
            this.land2 = a;
        }
    }

    // 이걸 어케쓴다냐..
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || !(obj instanceof LandPair))
            return false;
        LandPair o = (LandPair) obj;
        return this.land1 == o.land1 && this.land2 == o.land2;
    }

    @Override
    public int hashCode() {
        return 31 * land1 + land2;
    }

    @Override
    public String toString() {
        return "(" + land1 + ", " + land2 + ")";
    }
}

public class Main_다리만들기 {
    static int N, M;
    static int[][] paper;
    static boolean[][] visited;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static PriorityQueue<Edge> edges;
    static int[] boss;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 섬 넘버링
        visited = new boolean[N][M];
        int num = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (paper[i][j] == 1 && visited[i][j] == false) {
                    num++;
                    ArrayDeque<Integer[]> queue = new ArrayDeque<>();
                    queue.add(new Integer[] { i, j });
                    visited[i][j] = true;
                    paper[i][j] = num;
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
                            if (paper[nr][nc] == 1) {
                                queue.add(new Integer[] { nr, nc });
                                visited[nr][nc] = true;
                                paper[nr][nc] = num;
                            }
                        }
                    }
                }
            }
        }
        // for (int i = 0; i < N; i++) {
        // System.out.println(Arrays.toString(paper[i]));
        // }
        HashMap<LandPair, Integer> map = new HashMap<>();
        // LandPair a = new LandPair(1, 2);
        // map.put(a, 3);
        // map.put(a, 4);
        // System.out.println(map.get(a));
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (paper[i][j] != 0) {
                    int land1 = paper[i][j];
                    ArrayDeque<Integer[]> q = new ArrayDeque<>();
                    q.add(new Integer[] { i, j });
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        Integer[] tmp = q.poll();
                        int r = tmp[0];
                        int c = tmp[1];
                        for (int k = 0; k < 4; k++) {
                            int land2 = -1;
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if (!check(nr, nc)) {
                                continue;
                            }
                            if (visited[nr][nc] == true) {
                                continue;
                            }
                            if (paper[nr][nc] == 0) {
                                int cnt = 0;
                                while (check(nr, nc)) {
                                    if (paper[nr][nc] != 0) {
                                        land2 = paper[nr][nc];
                                        break;
                                    }
                                    nr += dr[k];
                                    nc += dc[k];
                                    cnt++;
                                }
                                if (land2 != -1 && cnt >= 2) {
                                    LandPair pair = new LandPair(land1, land2);
                                    map.merge(pair, cnt, (oldValue, newValue) -> Math.min(oldValue, newValue));
                                }
                            } else {
                                q.add(new Integer[] { nr, nc });
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }
        // for (LandPair pair : map.keySet()) {
        // System.out.println(pair + " " + map.get(pair));
        // }
        edges = new PriorityQueue<>();
        boss = new int[num + 1];
        for (int i = 0; i < num + 1; i++) {
            boss[i] = i;
        }

        for (LandPair pair : map.keySet()) {
            edges.offer(new Edge(pair.land1, pair.land2, map.get(pair)));
        }

        int result = 0;
        int bridge = 0;
        while (!edges.isEmpty() && bridge < num - 1) {
            Edge edge = edges.poll();
            if (Union(edge.s, edge.e)) {
                bridge++;
                result += edge.w;
            }
        }

        System.out.println(bridge == num - 1 ? result : -1);
    }

    private static boolean Union(int s, int e) {
        int sBoss = bossFind(s);
        int eBoss = bossFind(e);

        if (sBoss == eBoss) {
            return false;
        }

        boss[sBoss] = eBoss;
        return true;
    }

    private static int bossFind(int s) {
        if (s == boss[s]) {
            return s;
        }
        return boss[s] = bossFind(boss[s]);
    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < M;
    }
}

