//-----> ����, �ٽ� ����....
//https://blog.naver.com/PostView.nhn?blogId=neda712&logNo=221621436709&categoryNo=60&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=search
// ��ȭ���� ������� ����
// �ڵ�ȭ�ϱ� ���� ��� Ǯ�� �ذ��Ҽ� ������ ���� ������ �غ���.

/*
 https://healthydeveloper.tistory.com/39?category=675593 [�ǰ��Ѱ�����]
���ʺ��� Ž���ϴٰ� ���İ� ���� �ʴ� ������ ������ ��, ������ �����ʿ� ��ġ�ϴ°� ���� ������ ���Դϴ�. (�׸���)
���� n ��ġ�� ���İ� ���� �ʴ´ٸ� n+w�� �������� ��ġ�ϰ� n+w+w+1���� Ž���� ����� ������ ���� ���� �Դϴ�.
s+w ��ġ�� �������� �ִٸ� , �������� ��ġ�� �� �ִ� ���� �����ʿ� �������� ��ġ�մϴ�. 
*/

package org.programmers;

import java.util.ArrayList;

public class summercoding_2018_12979 {

	public static void main(String[] args) {
		int[] s = {1,11};
		solution(11, s, 1);

	}
	public static int solution(int n, int[] stations, int w) {
		int answer = 0;
		int idx = 0;
		int location = 1; // ���� ��ġ�� 1
		while (location <= n) {
			// ���� ��ġ�� ���İ� ���� ���� ��ġ �Ѵٸ�, ��ġ�� ���İ� ���� �ʴ� �� �ٷ� ������ �ű��
			if (location >= stations[idx]-w && idx<stations.length) {
				location = stations[idx] + w + 1;
				idx++; // ���� �������� ���Ǳ� ���� +1 �Ѵ�.
			} else {
				int newLocation = location + w;
				
				// ������ ������ ���� idx �����̰� && ��ġ�� ���� ������ - w ���� ũ�ų� ������ 
				if( (idx <= stations.length - 2) && newLocation >= stations[idx+1]-w )
					newLocation = stations[idx+1] - w - 1;  


				// ���� ��ġ�� ���İ� ���� �ʴ� ���̶��, �������� ��ġ�ϰ� ���İ� ���� ���� �ٷ� ���������� �̵��Ѵ�. 
				location = newLocation + w + 1;
				// �������� ��ġ�����Ƿ�
				++answer;
			}
		}
		return answer;
	}
}
