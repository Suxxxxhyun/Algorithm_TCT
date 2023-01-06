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

	static int n; //������ ���� ����
	static String target; //ã�� ���ڿ�
	static StringTokenizer st;
	static String[] str;
	
	public static void main(String[] args) throws IOException{
		
		System.out.println("������ ���� ������ �Է��� ���� ��ĭ ��� ã�� ���ڿ��� �Է��ϼ���.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		target = st.nextToken();
		
		System.out.println("�ռ� ���� ���Ұ�����ŭ ���ڿ��� �Է��ϼ���. ������ ���� ��ĭ���� �մϴ�.");
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
