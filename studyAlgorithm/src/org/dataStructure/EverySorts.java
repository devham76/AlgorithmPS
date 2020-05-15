package org.dataStructure;

import java.util.HashSet;

public class EverySorts {

	public static void main(String[] args) {
		int[] array = makeRandomArray(100000);
		EverySorts sort = new EverySorts();
		 sort.insertion(array);
		 sort.selection(array);
		 sort.bubble(array);
		 sort.shell(array);

		// -----------------
		 sort.quick(array);
		 sort.heap(array);
		 //sort.mergeSort(array);
	}

	private static int[] makeRandomArray(int size) {
		HashSet<Integer> hs = new HashSet<>();
		int[] rArr = new int[size];
		for (int i = 0; i < size; i++) {
			int num;
			do {
				num = (int) (Math.random() * size);
				if (!hs.contains(num)) {
					rArr[i] = num;
					hs.add(num);
					break;
				}
			} while (true);
		}
		return rArr;
	}

	// ----------------------------
	// ** 병합정렬 **
	// - 추가 공간필요, 안정적
	// 최선 : NlogN, 평균 : NlogN, 최악 : NlogN
	// ----------------------------
	private void mergeSort(int[] array) {
		int[] arr = array.clone();
		long stime = System.currentTimeMillis();
		
		Msort(arr, 0, arr.length);
		
		long etime = System.currentTimeMillis();
		time("merge",stime, etime);
	}


	private void Msort(int[] arr, int start, int end) {
		if (end - start <= 1) {
			return;
		}

		int mid = (start + end) / 2;
		Msort(arr, 0, mid);
		Msort(arr, mid, end);
		Mmerge(arr, start, mid, end);
	}

	private void Mmerge(int[] arr, int start, int mid, int end) {
		int[] tmp = new int[end - start];
		int idx = 0, s = start, e = mid;
		while (s < mid && e < end) {
			if (arr[s] < arr[e]) {
				tmp[idx++] = arr[s++];
			} else {
				tmp[idx++] = arr[e++];
			}
		}

		while (s < mid) {
			tmp[idx++] = arr[s++];
		}
		while (e < end) {
			tmp[idx++] = arr[e++];
		}

		for (int i = start; i < end; i++) {
			arr[i] = tmp[i - start];
		}
	}

	// ----------------------------
	// ** 힙정렬 **
	// - 완전이진트리, 힙 : 부모노드 > 자식노드 or 부모노드 < 자식노드
	// 최선 : NlogN, 평균 : NlogN, 최악 : NlogN
	// ----------------------------
	// https://www.youtube.com/watch?v=S42s_ANn4c4&feature=youtu.be
	private void heap(int[] array) {
		int[] arr = array.clone();
		long stime = System.currentTimeMillis();
		
		// ------ 1. 이진 트리 구조로 만들기.
		// int i = (arr.length-1)/ 2 ==> 자식을 갖는 마지막 노드 부터 힙 구조로 만들어준다
		// --> 마지막 서브트리의 루트 ~ 루트까지 검사해서 이진트리를 만든다.
		for (int i = (arr.length - 1) / 2; i >= 0; i--) {
			heapify(arr, i, arr.length - 1);
		}

		// ------ 2. 루트값을 제외한 나머지 값으로 최대힙다시 구성.
		int sizeOfHeap = arr.length - 1;
		for (int i = sizeOfHeap; i > 0; i--) {
			swap(arr, 0, i); // 루트값(최대)과 마지막 노드를 변경
			sizeOfHeap--; // 최대값 제외한 나머지 값으로
			// 최대힙을 다시구성한다.
			// 이때, 한층씩 내려가므로 logN번 반복하게된다
			heapify(arr, 0, sizeOfHeap);
		}
		
		long etime = System.currentTimeMillis();
		time("heap",stime, etime);
	}

	// 부모 > 자식 형태로 만들어준다
	private void heapify(int[] arr, int root, int size) {
		int left = 2 * root + 1;
		int right = 2 * root + 2;
		int max;

		if (left <= size && arr[left] > arr[root])
			max = left;
		else
			max = root;

		if (right <= size && arr[right] > arr[max])
			max = right;

		if (max != root) {
			swap(arr, root, max);
			heapify(arr, max, size);
		}

	}

	// ----------------------------
	// ** 퀵정렬 **
	// - 피벗구하기 (보통 성능을 배열의 가운데 값을 고른다)
	// 최선 : NlogN, 평균 : NlogN, 최악 n^
	// ----------------------------

	private void quick(int[] array) {
		int[] arr = array.clone();
		long stime = System.currentTimeMillis();
		
		quick_sort(arr, 0, arr.length - 1);
		
		
		long etime = System.currentTimeMillis();
		time("quick",stime, etime);
	}

	private void quick_sort(int[] arr, int left, int right) {
		int pl = left;
		int pr = right;

		int pivot = arr[(pl + pr) / 2]; // pivot
		do {
			// pivot보다 작은것 , pivot, pivot보다 큰것
			// 해당 규칙에 위배되는 index를 찾는다.
			while (arr[pl] < pivot)
				pl++;
			while (arr[pr] > pivot)
				pr--;

			if (pl <= pr)
				swap(arr, pl++, pr--);

		} while (pl <= pr);

		// 다음번 left, right를 실행할 수 잇는 조건이 충족 되면, 다시 실행
		if (left < pr)
			quick_sort(arr, left, pr);
		if (right > pl)
			quick_sort(arr, pl, right);
	}

	// ----------------------------
	// ** 셸정렬 **
	// - 삽입정렬->바로 뒤의 값과 비교
	// - 셸 정렬 -> 바로뒤x, 갭이 있다.
	// 최선 : n, 평균 : n1.5, 최악 n^
	// ----------------------------
	private void shell(int[] array) {
		int[] arr = array.clone();
		
		long stime = System.currentTimeMillis();
		
		for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
			gap = (gap % 2 == 0) ? gap + 1 : gap; // 홀수로 만든다.

			// 부분 리스트의 개수는 gap과 같다.
			for (int i = 0; i < gap; i++) {
				// 부분 리스트에 대한 삽입 정렬 수행
				shell_sort(arr, i, arr.length - 1, gap);
			}
		}
		
		long etime = System.currentTimeMillis();
		time("shell",stime, etime);
	}

	private void shell_sort(int[] arr, int start, int end, int gap) {

		for (int i = start + gap; i <= end; i += gap) {
			int insert = arr[i]; // 배열의 원소를 순서대로 선택한다
			int compareIdx = i - gap; // 비교 대상 이전의 것들과 비교한다

			while (insert < arr[compareIdx]) {
				arr[compareIdx + gap] = arr[compareIdx];
				compareIdx -= gap;
				if (compareIdx < start)
					break;
			}

			arr[compareIdx + gap] = insert;
		}
	}

	// ----------------------------
	// ** 버블정렬 **
	// - 두개씩 비교
	// - 배열의 맨뒤부터 정렬된다
	// 최선 : n^, 평균 : n^, 최악 n^
	// ----------------------------
	private void bubble(int[] array) {
		int[] arr = array.clone();
		long stime = System.currentTimeMillis();
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
		
		long etime = System.currentTimeMillis();
		time("bubble",stime, etime);
	}

	// ----------------------------
	// ** 선택정렬 **
	// - 정렬안된 배열에서 가장 작은 수 찾아서 맨왼쪽에 위치시킨다.
	// - 너무너무 최악 ~
	// 최선 : n^, 평균 : n^, 최악 n^
	// ----------------------------
	private void selection(int[] array) {
		int[] arr = array.clone();
		long stime = System.currentTimeMillis();
		for (int i = 0; i < arr.length; i++) {
			int min = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}

			if (min != i) {
				swap(arr, i, min);
			}
		}
		
		long etime = System.currentTimeMillis();
		time("selection",stime, etime);

	}

	// ----------------------------
	// ** 삽입정렬 **
	// - 원소를 순서대로 선택하면서 앞에 이미 정렬된것과 비교
	// - 안정적적렬
	// 최선 : n, 평균 : n^, 최악 n^
	// ----------------------------
	public void insertion(int[] array) {
		int[] arr = array.clone();
		long stime = System.currentTimeMillis();
		
		for (int i = 1; i < arr.length; i++) {
			int insert = arr[i]; // 배열의 원소를 순서대로 선택한다
			int compareIdx = i - 1; // 비교 대상 이전의 것들과 비교한다

			while (insert < arr[compareIdx]) {
				arr[compareIdx + 1] = arr[compareIdx];
				compareIdx--;
				if (compareIdx < 0)
					break;
			}

			arr[compareIdx + 1] = insert;
		}
		
		long etime = System.currentTimeMillis();
		time("insertion",stime, etime);
	}

	static void swap(int[] array, int x, int y) {
		int tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
	}

	static void print(int[] array) {
		for (Integer a : array)
			System.out.print(a + " ");
		System.out.println();
	}
	private void time(String sort, long stime, long etime) {
		System.out.println(sort+" : "+(etime-stime)/1000.0);
		
	}
}
