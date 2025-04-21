package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_전화번호 {
    static class TrieNode {
        TrieNode[] children;
        boolean finish;

        public TrieNode() {
            this.children = new TrieNode[10];
            this.finish = false;
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // 숫자 삽입
        public boolean insert(String num) {
            TrieNode cur = root;

            int len = num.length();
            int cnt = 0;

            for (int i = 0; i < len; i++) {
                int baby = num.charAt(i) - '0';

                if (cur.children[baby] == null) {
                    cnt++;
                    cur.children[baby] = new TrieNode();
                }

                cur = cur.children[baby];
                if (cur.finish)
                    return true;
            }

            cur.finish = true;

            if (cnt == 0)
                return true;
            return false;
        }
    }

    static int T;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(st.nextToken());

        for (int TC = 0; TC < T; TC++) {
            N = Integer.parseInt(br.readLine());

            Trie trie = new Trie();
            boolean result = false;

            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                if (result)
                    continue;
                if (trie.insert(input)) {
                    sb.append("NO\n");
                    result = true;
                }
            }
            if (!result)
                sb.append("YES\n");
        }
        System.out.println(sb);
    }
}