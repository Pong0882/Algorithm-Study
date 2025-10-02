import java.io.*;

public class Main_괄호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int bal = 0;
            boolean ok = true;

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '(')
                    bal++;
                else {
                    if (bal == 0) {
                        ok = false;
                        break;
                    }
                    bal--;
                }
            }
            if (bal != 0)
                ok = false;
            sb.append(ok ? "YES" : "NO").append('\n');
        }
        System.out.print(sb);
    }
}
