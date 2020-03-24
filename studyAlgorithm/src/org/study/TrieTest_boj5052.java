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
		
		while(T>0) {
			T--;
			
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
					System.out.println("c ==>"+c);
					if( node.nxt[c-'0'] == null) {
						node.cnt++;	// 이 전글자의 node수 증가
						node.nxt[c-'0']  = new Node(c,0);
						System.out.println(node.cnt+" , c-'0':"+(c-'0'));
					}
					
					// 해당 글자를 가르킨다.
					node = node.nxt[c-'0'];
					System.out.println("data="+node.data+" cnt="+node.cnt);
				}
				
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
