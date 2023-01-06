package part02.ch05;

public class FactorialRecusiveP132 {
	
	public static int factorialIterative(int n) {
		int result = 1;
		for(int i=1; i<=n; i++) {
			result *= i;
		}
		return result;
	}
	
	public static int factorialRecursive(int n) {
		if(n <= 1) {
			return 1;
		}
		return n * factorialRecursive(n-1);
		
	}
	
	
	
	public static void main(String[] args) {
		
		// ������ ������� ������ n! ���(n = 5)
		System.out.println("�ݺ������� ����: " + factorialIterative(5));
		System.out.println("��������� ����:" + factorialRecursive(5));

	}

}
