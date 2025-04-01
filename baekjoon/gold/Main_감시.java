package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_감시{
    static int R, C;
    static int[][] paper;
    static int d;
    static boolean[][] visited;
    static boolean[][] copy;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static List<Integer[]> cctv = new ArrayList<>();
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        paper = new int[R][C];
        visited = new boolean[R][C];
        copy = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = true;
                if(paper[i][j]>=1 && paper[i][j] <=5){
                    cctv.add(new Integer[] {paper[i][j], i, j});
                }
            }
        }

        gogo();
    }
    private static void gogo() {
        for (int d = 0; d < 4; d++) {
            for (int i = 0; i < cctv.size(); i++) {
                check(i, d);
            }
        }
    }
    private static void check(int index, int d) {
        Integer[] tmp = cctv.get(index);
        int type = tmp[0];
        int r = tmp[1];
        int c = tmp[2];

        switch (type) {
            case 1 -> one(r,c,d);
            case 2 -> two(r,c,d);
            case 3 -> thr(r,c,d);
            case 4 -> fou(r,c,d);
            case 5 -> fiv(r,c,d);
        }
    }
    private static void fiv(int r, int c,int d) {
    }
    private static void fou(int r, int c,int d) {
    }
    private static void thr(int r, int c,int d) {
    }
    private static void two(int r, int c,int d) {
    }
    private static void one(int r, int c,int d) {
        while (okCheck()) {
            
        }
    }
    private static boolean okCheck() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'okCheck'");
    }
}