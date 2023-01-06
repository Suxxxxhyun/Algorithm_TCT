package part02.ch06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//���1 -> �Է¹������� ArrayList�� ���� ��� -> Collections.sort(arr,Collections.reversOrder())
public class QuestionP178 {
	
	public static int n;
	public static ArrayList<Integer> arr = new ArrayList<Integer>();
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			arr.add(sc.nextInt());
		}
		
		Collections.sort(arr, Collections.reverseOrder());
		
		for(int i=0; i<arr.size(); i++) {
			sb.append(arr.get(i) + " ");
		}
		
		System.out.println(sb);
	}

}
