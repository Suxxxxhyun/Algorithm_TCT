package part02.ch04;

import java.util.Scanner;

//�ݺ��� �̿��ϴ� �� -> ����
//����Լ� �̿��ؼ� �ϴ°͵� ����غ����ҵ�! -> ���� �õ�����. -> ���ʿ� (�ð�), (��,��)�� ������ ���� �ð��� 0~N, ��,�ʴ� 0~59�̱� ������
//������ �޶� ����Լ��� ��Ǫ�°Ͱ���(����Լ��� Ǯ����� �Ѱ��� TimeP113Recursive)
//������ ������ Ǯ�� ���Ұ�
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
		// 1. str += h + m + s��, 2. str = str + h + m + s�� ������ 
		// ��������� ���� �ٸ���
		// 1. str += h + m + s�� str = str + (h + m + s)�ΰ��̰�
		// 2. str = str + h + m + s�� ���ʺ��� ������� �������� �����̴�.

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
