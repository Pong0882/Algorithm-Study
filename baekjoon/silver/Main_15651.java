package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15651 {
    private static int[] result; // 현재 순열을 저장할 배열
    private static int N, R; // 전체 원소 수(N)와 선택할 원소 수(R)
    private static StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        R = Integer.parseInt(input[1]);

        result = new int[R]; // 길이가 R인 순열 저장 배열

        PermRe(0); // 순열 생성 시작
        System.out.println(sb); // 최종 결과 출력
    }

    private static void PermRe(int depth) {
        // Base Condition: 순열이 완성되었을 때
        if (depth == R) {
            for (int i = 0; i < R; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 1부터 N까지 숫자를 탐색하며 순열 생성
        for (int i = 0; i < N; i++) {
            result[depth] = i + 1; // 1부터 시작하는 숫자 저장
            PermRe(depth + 1); // 다음 깊이 탐색
        }
    }
}
