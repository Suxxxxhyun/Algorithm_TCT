package part02.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 5 3
1 2 5 4 3
5 5 6 6 5
 */

public class QuestionP182 {
	
	//n�� �ִ��� �ִ� �ʸ��̹Ƿ�, �迭 A�� B�� �����ϴµ� �ð����⵵�� �� 10��*log10��*2 => 320���� �ð����⵵�� �ҿ��.
	//�� �迭�� ������ �ִ��� õ���̹Ƿ� Integer�迭�� �־��� ������.
	static int n,k,sum;
	static StringTokenizer st;
	static Integer[] A,B;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		A = new Integer[n];
		B = new Integer[n];
		sum = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());
		
		for(int i=0; i<k; i++) {
			if(A[i] < B[i]) {
				A[i] = B[i];
			}
		}
		
		for(int i=0; i<n; i++) {
			sum += A[i];
		}
		
		System.out.println(sum);
		
		
	}

}
