package part02.ch04;

import java.util.Scanner;

public class TimeP113Recursive {

	public static int N;
	public static int[] selected = new int[3];
	public static int count = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		//recf(0,3); 
		//ù���� ���ڴ� '��', ���� ������ 0~23�̴� �ϰ����� ���� �ʾ� ���ڷ� ���� ����.
		//�ι�° ���ڴ� selected�� �ε���
		recf(2);
	}
	
	public static void recf(int x) {
		
		if(x < 0) {
			if(pruning()) {
				for(int i=0; i<=2; i++) {
					System.out.print(selected[i] + " ");
				}
				System.out.println();
				return;
			}
			return;
		}
		
		int end = 60;
		
		if(x == 0) {
			end = N+1;
		}
		
		for(int i=0; i<end; i++) {
			selected[x] = i;
			recf(x-1);
		}
		
		System.out.println(count);
	}
	
	public static boolean pruning() {
		String str = "";
		
		for(int i=0; i<=2; i++) {
			str = str + selected[i];
		}
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '3') {
				count++;
				return true;
			}
		}
		return false;
	}

}
