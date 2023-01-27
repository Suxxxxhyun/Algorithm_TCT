package part02.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 10 7
1 3 5 7 9 11 13 15 17 19

10 7
1 3 5 6 9 11 13 15 17 19
 */
public class BinarySearchRecursiveP189 {
	
	static int n, target; //n�� ������ ����, target�� ã���� �ϴ� ����
	static StringTokenizer st;
	static int[] arr;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

	
		binarySearch(0,n-1);
		
	}
	
	static void binarySearch(int start, int end) {
		
		if(start > end) {
			System.out.println("�ش� ���Ұ� �������� �ʽ��ϴ�.");
			return;
		}
		
		
		int mid = (start + end) / 2;
		
		if(arr[mid] == target) {
			System.out.println(mid + 1);
			return;
		} else if(arr[mid] < target) {
			start = mid + 1;
			binarySearch(start, end);
		} else {
			end = mid - 1;
			binarySearch(start, end);
		}
	}

}
