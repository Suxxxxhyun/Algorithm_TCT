package part02.ch05;

import java.util.LinkedList;
import java.util.Queue;

public class QueueP129 {

	public static void main(String[] args) {
		
		// ����(5) - ����(2) - ����(3) - ����(7) - ����() - ����(1) - ����(4) - ����()
		Queue<Integer> q = new LinkedList<>();
		q.offer(5);
		q.offer(2);
		q.offer(3);
		q.offer(7);
		q.poll();
		q.offer(1);
        q.offer(4);
        
        // ���� ���� ���Һ��� ����
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
	}

}
