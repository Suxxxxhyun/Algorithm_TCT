package part02.ch06;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class QuestionP17802 {
	
	public static Integer[] arr;
	public static int N;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new Integer[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
