package part02.ch09;

public class exFor {

	public static void main(String[] args) {
		
		int a = 0;
		int b = 0;
		System.out.println(a==b); //1��
		
		System.out.println();
		
		Integer c = new Integer(5);
		Integer d = 5;
		
		System.out.println(c==d); //2��
		System.out.println(c.equals(d)); //3��
		
		System.out.println();
		
		Student st1 = new Student(2020, "park");
		Student st2 = new Student(2020, "park");
		
		System.out.println(st1==st2); //4��
		System.out.println(st1.equals(st2)); //5��
		
		System.out.println();
		
		String str5 = "";
		String str6 = "�ȳ�";
		System.out.println(str5.equals(str6)); //6��
		
		String str3 = null;
		String str4 = "�ȳ��ϼ���";
		System.out.println(str3.equals(str4));
	}

}

class Student{
	private int studentID;
	private String name;
	
	public Student(int studentID, String name) {
		this.studentID = studentID;
		this.name = name;
	}
}
