package part02.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 5 Dongbin
 * Hanul Jonggu Dongbin Taeil Sangwook
 */

public class SequentialSearchP187 {

	static int n; //생성할 원소 개수
	static String target; //찾읆 문자열
	static StringTokenizer st;
	static String[] str;
	
	public static void main(String[] args) throws IOException{
		
		System.out.println("생성할 원소 개수를 입력한 다음 한칸 띄고 찾을 문자열을 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		target = st.nextToken();
		
		System.out.println("앞서 적은 원소개수만큼 문자열을 입력하세요. 구분은 띄어쓰기 한칸으로 합니다.");
		st = new StringTokenizer(br.readLine(), " ");
		str = new String[n];
		
		for(int i=0; i<n; i++) {
			str[i] = st.nextToken();
		}
		
		for(int i=0; i<n; i++) {
			if(target.equals(str[i])) {
				System.out.println(i+1);
				break;
			}
		}
		
	}

}
