
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, K;
    static int[] dr = { 0, 0, -1, 1 };
    static int[] dc = { 1, -1, 0, 0 };
    static int[][] paper;
    static boolean[][] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        paper = new int[R][C];
        for (int i = 0; i < R; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (c[j] == '.') {
                    paper[i][j] = 0;
                } else {
                    paper[i][j] = -1;
                }
            }
        }
        visited = new boolean[R][C];
        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);
        System.out.println(result);
    }

    private static void dfs(int r, int c, int cnt) {
        if (r == 0 && c == C - 1 && cnt == K) {
            result++;
            return;
        }
        // System.out.println(r + " " + c + " " + cnt);
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!check(nr, nc)) {
                continue;
            }
            if (paper[nr][nc] == -1) {
                continue;
            }
            if (visited[nr][nc]) {
                continue;
            }
            visited[nr][nc] = true;
            dfs(nr, nc, cnt + 1);
            visited[nr][nc] = false;
        }
    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < R && nc < C;
    }
}
