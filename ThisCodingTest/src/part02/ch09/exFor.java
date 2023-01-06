package part02.ch09;

public class exFor {

	public static void main(String[] args) {
		
		int a = 0;
		int b = 0;
		System.out.println(a==b); //1번
		
		System.out.println();
		
		Integer c = new Integer(5);
		Integer d = 5;
		
		System.out.println(c==d); //2번
		System.out.println(c.equals(d)); //3번
		
		System.out.println();
		
		Student st1 = new Student(2020, "park");
		Student st2 = new Student(2020, "park");
		
		System.out.println(st1==st2); //4번
		System.out.println(st1.equals(st2)); //5번
		
		System.out.println();
		
		String str5 = "";
		String str6 = "안녕";
		System.out.println(str5.equals(str6)); //6번
		
		String str3 = null;
		String str4 = "안녕하세요";
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
