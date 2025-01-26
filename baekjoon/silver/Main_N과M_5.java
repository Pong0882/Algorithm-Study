package baekjoon.silver;

// String으로 받아서 정렬했더니 12 보다 2 가 오른쪽으로 정렬되어버림..
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_N과M_5 {
    private static boolean[] visited; // 방문 여부 체크 >> 중복 X
    private static int[] card;
    private static int[] result; // 현재 순열을 저장할 배열
    private static int N, R; // 전체 원소 수(N)와 선택할 원소 수(R)
    private static StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        R = Integer.parseInt(input[1]);

        st = new StringTokenizer(br.readLine());
        card = new int[N];
        result = new int[R];
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        visited = new boolean[N]; // 방문 여부를 체크하는 배열

        Perm(0); // 순열 생성 시작
        System.out.print(sb.toString().trim()); // 최종 결과 출력
    }

    private static void Perm(int depth) {
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
            if (!visited[i]) { // 아직 방문하지 않은 숫자라면
                visited[i] = true; // 방문 체크
                result[depth] = card[i]; // 1부터 시작하는 숫자 저장
                Perm(depth + 1); // 다음 깊이 탐색
                visited[i] = false; // 백트래킹 (방문 해제)
            }
        }
    }
}
