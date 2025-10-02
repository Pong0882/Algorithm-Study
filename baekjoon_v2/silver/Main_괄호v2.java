import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_괄호v2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            Deque<Character> st = new ArrayDeque<>(); // 케이스마다 새로 생성
            boolean ok = true;

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '(')
                    st.push('(');
                else if (!st.isEmpty())
                    st.pop();
                else {
                    ok = false;
                    break;
                }
            }
            if (!st.isEmpty())
                ok = false;
            sb.append(ok ? "YES" : "NO").append('\n');
        }
        System.out.print(sb);
    }
}
