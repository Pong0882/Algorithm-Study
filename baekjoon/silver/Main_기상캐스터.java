package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_기상캐스터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int paper[][] = new int[a][b];
        for (int i = 0; i < a; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < b; j++) {
                if (c[j] == '.') {
                    paper[i][j] = -1;
                } else {
                    paper[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (paper[i][j] == 0) {
                    int cnt = 0;
                    for (int j2 = j; j2 < b; j2++) {
                        if (j == j2)
                            paper[i][j2] = 1;
                        if (paper[i][j2] == 0) {
                            break;
                        }
                        paper[i][j2] = cnt++;
                    }
                    paper[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(paper[i][j] + " ");
            }
            System.out.println();
        }
    }
}
