package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_거짓말 {
    static int n, m;
    static int[] boss;
    static int result;
    static boolean[] lierArr;
    static ArrayList<Integer>[] liers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // 보스
        boss = new int[n + 1];
        lierArr = new boolean[n+1];
        for (int i = 0; i < n + 1; i++) {
            boss[i] = i;
        }
        // 거짓말쟁이
        st = new StringTokenizer(br.readLine());
        int lier = Integer.parseInt(st.nextToken());
        for (int i = 0; i < lier; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            boss[tmp] = 0;
        }
        
        liers = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            liers[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < Integer.parseInt(st.nextToken()); j++) {    
                liers[i].add(Integer.parseInt(st.nextToken()));
            }
            
        }
    }
}
