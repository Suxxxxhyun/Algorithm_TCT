package part02.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class QuestionP180 {
	
	public static int n;
	//기본적으로 우선순위큐 구조는 최소힙구조
	public static PriorityQueue<Student> pq = new PriorityQueue<Student>();
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			pq.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken())));
		}
		
		while(!pq.isEmpty()) {
			//Student st = pq.poll();
			sb.append(pq.poll().getName()).append(" ");
		}
		
		System.out.println(sb);
	
	}

}

class Student implements Comparable<Student>{
	private String name;
	private int grade;
	
	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int compareTo(Student stu) {
		return this.grade - stu.grade;
	}
}
