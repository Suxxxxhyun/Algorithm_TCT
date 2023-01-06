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
public class BinarySearchWhileP190 {
	
	static int n, target; //n은 원소의 개수, target은 찾고자 하는 원소
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
		boolean find = false;
		while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
            	System.out.println(mid + 1);
            	find = true;
            	break;
            }
            else if (arr[mid] > target) {
            	end = mid - 1;
            }
            else start = mid + 1; 
        }
		if(find == false) {
			System.out.println("원소가 존재하지 않습니다.");
		}
	}

}
