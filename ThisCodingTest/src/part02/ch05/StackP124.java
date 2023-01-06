package part02.ch05;

import java.util.Stack;

public class StackP124 {

	public static void main(String[] args) {
		
		// ����(5) - ����(2) - ����(3) - ����(7) - ����() - ����(1) - ����(4) - ����()
		Stack<Integer> s = new Stack<>();
		s.push(5);
		s.push(2);
		s.push(3);
		s.push(7);
		s.pop();
		s.push(1);
        s.push(4);
        s.pop();
        
        while(!s.empty()) {
        	//System.out.println(s.pop());
        	System.out.println(s.peek());
        	s.pop();
        }
		

	}

}
