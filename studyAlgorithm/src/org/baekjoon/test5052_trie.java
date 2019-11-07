package org.baekjoon;

/*
1
3
911
97625999
91125426
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class test5052_trie {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            int n = Integer.parseInt(br.readLine());
            String[] num = new String[n];

            Trie trie = new Trie();
            boolean ret = true;

            for (int i = 0; i < n; i++) {

                num[i] = br.readLine();
            }

            // ������������ ����
            Arrays.sort(num);

            for (int i = 0; i < n; i++) {
            	// Ʈ���̿� ������ �ȵǸ� ����.
                if (!trie.insert(num[i])) {
                    ret = false;
                    break;
                }
            }

            System.out.println(ret ? "YES" : "NO");
        } // ~ test case loop
    }
}

class Trie {

    private TrieNode root;

    Trie() {

        root = new TrieNode();
    }

    private int toNumber(char c) {

        return c - '0';
    }

    boolean insert(String key) {

        TrieNode currentNode = root;
        int length = key.length();

        // ���ڿ� ���� ��ŭ ����
        for (int i = 0; i < length; i++) {

            char c = key.charAt(i);
            int next = toNumber(c);

            if (currentNode.children[next] == null) {

                currentNode.children[next] = new TrieNode();
            }

            
            currentNode = currentNode.children[next];
            // i = length-1 => ���ڿ��� ���̸� terminal = true  
            if (currentNode.isTerminal && i + 1 < length) {

                return false;
            }
        }

        currentNode.isTerminal = true;

        return true;
    }
}

class TrieNode {

    TrieNode[] children = new TrieNode[10];
    boolean isTerminal;

    TrieNode() {

        isTerminal = false;
        // ��ȭ��ȣ ���� 10�ڸ�
        for (int i = 0; i < 10; i++) {

            children[i] = null;
        }
    }
}