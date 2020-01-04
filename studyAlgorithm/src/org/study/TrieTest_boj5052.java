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
			int N = nextInt();	// 전화번호 수
			
			Node root = new Node('r',0);
			for(int n=1; n<=N; n++) {
				Node node = root;
				String str = nextLine();	// 전화번호 한줄읽음
				
				for (int i=0; i<str.length(); i++) {
					char c = str.charAt(i);
					// 해당 글자로 시작하는 가지가 없으면
					// 해당 글자로 시작하는 가지를 만들어준다
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
					// 현재 노드는 만들어진 노드가 된다?
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
			// res 가 전화번호 수가 아니라면 
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
		// node의 개수가 0이 아니라면
		// node자식 최대 개수10
		for (int i=0; i<10; i++) {
			// node의 자식이 있다면 node의 자식도 찾아본다
			if(node.nxt[i] != null)
				searchLeaf(node.nxt[i]);
		}
	}

}
class Node {
	char data;
	int cnt;
	Node[] nxt = new Node[10];	// 전화번호는 길어야 10자리
	
	public Node(char data, int cnt) {
		this.data = data;
		this.cnt = cnt;
	}
}
