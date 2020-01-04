package org.study;
//https://code0xff.tistory.com/76
//https://kim6394.tistory.com/175
//https://m.blog.naver.com/javaking75/140211950640
import java.io.*;

public class TrieTest_boj5052 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int i;
	private static String str;
	private static int res;
	static int nextInt() {
		try {
			i =  Integer.parseInt(br.readLine().trim());
		}catch (Exception e) {}
		return i;
	}
	static String nextLine() {
		try {
			str =  br.readLine().trim();
		}catch (Exception e) {}
		return str;
	}
	public static void main(String[] args) {
		int T = nextInt();	// testcase
		
		for(int t=1; t <=T; t++) {
			int N = nextInt();	// ��ȭ��ȣ ��
			
			Node root = new Node('r',0);
			for(int n=1; n<=N; n++) {
				Node node = root;
				String str = nextLine();	// ��ȭ��ȣ ��������
				
				for (int i=0; i<str.length(); i++) {
					char c = str.charAt(i);
					// �ش� ���ڷ� �����ϴ� ������ ������
					// �ش� ���ڷ� �����ϴ� ������ ������ش�
					// c-'0' : char to int
					if( node.nxt[c-'0'] == null) {
						node.cnt++;
						node.nxt[c-'0']  = new Node(c,0);
						System.out.println(node.cnt+" , c-'0':"+(c-'0'));
						for(int k=0; k<node.nxt.length;k++){
							System.out.print(node.nxt[k]+" ");
						}
						System.out.println();
					}
					// ���� ���� ������� ��尡 �ȴ�?
					node = node.nxt[c-'0'];
				}
				
				System.out.println("---------node cnt:"+root.cnt);
				for(int k=0; k<root.nxt.length;k++){
					System.out.print(root.nxt[k]+" ");
				}
				System.out.println();
			}
			res = 0;
			searchLeaf(root);
			// res �� ��ȭ��ȣ ���� �ƴ϶�� 
			if(res != N)
				System.out.println("No");
			else
				System.out.println("YES");
			
		}
	}
	public static void searchLeaf(Node node) {
		if (node.cnt == 0) {
			res++;
			return;
		}
		// node�� ������ 0�� �ƴ϶��
		// node�ڽ� �ִ� ����10
		for (int i=0; i<10; i++) {
			// node�� �ڽ��� �ִٸ� node�� �ڽĵ� ã�ƺ���
			if(node.nxt[i] != null)
				searchLeaf(node.nxt[i]);
		}
	}

}
class Node {
	char data;
	int cnt;
	Node[] nxt = new Node[10];	// ��ȭ��ȣ�� ���� 10�ڸ�
	
	public Node(char data, int cnt) {
		this.data = data;
		this.cnt = cnt;
	}
}
