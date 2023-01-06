package part02.ch05;

import java.util.Stack;

public class StackP124 {

	public static void main(String[] args) {
		
		// »ğÀÔ(5) - »ğÀÔ(2) - »ğÀÔ(3) - »ğÀÔ(7) - »èÁ¦() - »ğÀÔ(1) - »ğÀÔ(4) - »èÁ¦()
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
