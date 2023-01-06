package part02.ch04;

import java.util.Scanner;

//반복문 이용하는 것 -> 성공
//재귀함수 이용해서 하는것도 고민해봐야할듯! -> 아직 시도안함. -> 애초에 (시각), (분,초)의 범위가 각각 시각은 0~N, 분,초는 0~59이기 때문에
//범위가 달라서 재귀함수로 못푸는것같음(재귀함수로 풀어보려고 한곳은 TimeP113Recursive)
//나동빈 깃허브와 풀이 비교할것
public class TimeP113 {
	
	public static int N;
	public static int count = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		recFunc();
		System.out.println(count);
	}
	
	public static void recFunc() {
	
		for(int k=0; k<=N; k++) {
			for(int j=0; j<60; j++) {
				for(int i=0; i<60; i++) {
					
					if(confirm(k,j,i)) {
						count++;
					};
				}
			}
		}
	}
	
	public static boolean confirm(int h, int m, int s) {
		String str = "";
		str = str + h + m + s;
		int cnt = 0;
		//System.out.println(str);
		// 1. str += h + m + s는, 2. str = str + h + m + s와 같지만 
		// 연산순서가 서로 다르다
		// 1. str += h + m + s는 str = str + (h + m + s)인것이고
		// 2. str = str + h + m + s는 왼쪽부터 차레대로 더해지는 순서이다.

		for(int i=0; i < str.length(); i++) {
			int n = str.charAt(i) - '0';
			if(n == 3) {
				cnt++;
			}
		}
		
		if(cnt == 0) {
			return false;
		} else {
			return true;
		}
	}

}
