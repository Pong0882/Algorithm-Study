package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_트리순회 {
    private static int N;
    private static Queue<String> val = new ArrayDeque<>();
    private static Map<String, String[]> tree = new HashMap<>();

    private static StringBuilder pre = new StringBuilder();
    private static StringBuilder in = new StringBuilder();
    private static StringBuilder post = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            tree.put(root, new String[] { left, right });
        }

        // for (String s : tree.keySet()) {
        // System.out.println(s + Arrays.toString(tree.get(s)));
        // }

        dfs(0, "A");
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);

    }

    private static void dfs(int cnt, String r) {

        String root = r;
        String left = tree.get(root)[0];
        String right = tree.get(root)[1];

        // System.out.println(root + left + right + cnt); // 이거
        pre.append(root);
        if (!left.equals(".")) {
            dfs(cnt + 1, left);
        }
        in.append(root);
        if (!right.equals(".")) {
            dfs(cnt + 1, right);
        }
        post.append(root);
    }
}
