package part02.ch05;

public class RecursiveFunctionP130 {
	
	public static void recursiveFunction(int i) {
		if(i == 100) {
			return;
		}
		System.out.println(i + "��° ��� �Լ����� " + (i + 1) + "��° ����Լ��� ȣ���մϴ�.");
        recursiveFunction(i + 1);
        System.out.println(i + "��° ��� �Լ��� �����մϴ�.");
	}

	public static void main(String[] args) {
		
		 recursiveFunction(1);

	}

}
