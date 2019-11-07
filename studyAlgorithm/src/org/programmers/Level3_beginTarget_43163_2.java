package org.programmers;
import java.util.LinkedList;
import java.util.Queue;

public class Level3_beginTarget_43163_2 {
	public static void main(String[] args) {
		String b = "hit";
		String t = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

		solution(b,t,words);

	}	
	
    static class Node {
        String next;
        int edge;

        public Node(String next, int edge) {
            this.next = next;
            this.edge = edge;
        }
    }

    public static int solution(String begin, String target, String[] words) {
        int n = words.length;
        int ans = 0;
        boolean[] visit = new boolean[n];
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(begin, 0));

       //BFS
        while(!q.isEmpty()) {
            Node cur = q.poll();
            // ���� �� �ܾ Ÿ�ٰ� ������, ������ ��ȯ�ϰ� ���̳���.
            // ���� �켱 Ž���̹Ƿ� ���� ª�� ���� ���� ���� ��ȯ �� �� ���̴�!!! 
            if (cur.next.equals(target)) {
                ans = cur.edge;
                break;
            }

            for (int i=0; i<n; i++) {
                if (!visit[i] && isNext(cur.next, words[i])) {
                    visit[i] = true;
                    q.add(new Node(words[i], cur.edge + 1));
                }
            }
        }
        System.out.println(ans);
        return ans;
    }

    static boolean isNext(String cur, String n) {
        int cnt = 0;
        for (int i=0; i<n.length(); i++) {
            if (cur.charAt(i) != n.charAt(i)) {
            	// �� �ܾ��� �ٸ� ���ڰ� 1�� �ʰ� �̸� ������ ��ȯ.
                if (++ cnt > 1) return false;
            }
        }
        return true;
    }    
}
