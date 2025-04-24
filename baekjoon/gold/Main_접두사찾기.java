package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_접두사찾기 {
    static class TrieNode {
        TrieNode[] children;
        boolean finish;

        public TrieNode() {
            this.children = new TrieNode[26];
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
                int baby = num.charAt(i) - 'a';

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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        
        Trie trie = new Trie();
        for (int i = 0; i < N; i++) {
            String S = br.readLine();
            trie.insert(S);
        }
        for (int i = 0; i < M; i++) {
            String S =br.readLine();
            if(trie.check(S)){
                result++;
            }
            
        }
        System.out.println( result);
    }
}