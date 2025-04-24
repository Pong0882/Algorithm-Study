package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_게임닉네임 {
    static class TrieNode {
        TrieNode[] children;
        boolean finish;
        int count;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.finish = false;
            this.count = 0;
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // 숫자 삽입
        public void insert(String num) {
            TrieNode cur = root;

            int len = num.length();
            int cnt = 0;
            boolean flag = false;

            for (int i = 0; i < len; i++) {
                int baby = num.charAt(i) - 'a';

                if (cur.children[baby] == null) {
                    if (!flag)
                        sb.append(num.charAt(i));
                    flag = true;
                    cnt++;
                    cur.children[baby] = new TrieNode();
                }

                if (!flag)
                    sb.append(num.charAt(i));
                cur = cur.children[baby];
                // if (cur.finish)
                // return true;
            }
            // 전부 동일하다면
            if (!flag && cur.count > 0)
                sb.append(cur.count + 1);

            cur.count++;

            cur.finish = true;

            // if (cnt == 0)
            // return true;
            // return false;
        }
        // public void check(String s){

        // }
        public boolean check(String word) {
            TrieNode cur = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (cur.children[index] == null) {
                    return false;
                }
                cur = cur.children[index];
            }
            return true;
        }
    }

    static int result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        // int M= Integer.parseInt(st.nextToken());

        Trie trie = new Trie();
        for (int i = 0; i < N; i++) {
            String S = br.readLine();
            trie.insert(S);
            sb.append("\n");
        }
        // for (int i = 0; i < M; i++) {
        // String S =br.readLine();
        // if(trie.check(S)){
        // result++;
        // }

        // }
        System.out.println(sb);
    }
}