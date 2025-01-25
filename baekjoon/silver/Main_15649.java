package baekjoon.silver;

// 순열(Permutation) nPr
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;
    // 중복이 허용 되지 않을 경우 visited[] 해줘야함.
    private static boolean[] visited;
    // 출력값을 저장할 리스트 만들기
    private static int[] result;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 초기화
        visited = new boolean[N];
        // N개의 카드에 대하여 사용 여부를 체크 해야하기때문에 N크기로 생성

        result = new int[M];
        // M개의 카드를 저장해 두었다 출력 해야하므로 M크기로 생성

        // 기본적으로 Permuatation은 얼마나 들어갔다 체크하는 cnt, Depth가 필요함
        Perm(0);
        System.out.println(sb);
    }

    private static void Perm(int cnt) {
        // 백트레킹의 경우 처음엔 Base Condition을 설정 해주어야 한다.
        if (cnt == M) { // 이 문제에서 Depth의 역할을 M이 하고 있다.
            // cnt가 Depth 값까지 들어왔을경우 result에 있는 값들을 출력시킨다.
            for (int num : result) {
                sb.append(num + " ");
            } // 향상된 for과 스트링 뷸더를 사용해 보자.
            sb.append("\n");
            // 리턴은 필수!
            return;
        }

        // 1번부터 N번 까지 확인한다.
        for (int i = 0; i < N; i++) {
            if (!visited[i]) { // visited 가 F 이면 result[cnt]에 값을 넣고 T로 바꿔준다.
                result[cnt] = i + 1;
                visited[i] = true;
                Perm(cnt + 1); // 재귀한다.
                visited[i] = false; // 빠져나왔으니 visited는 F가 되어야 할 것이다.
            }
        }
    }
}
