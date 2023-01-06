package part02.ch09;

public class Node implements Comparable<Node>{
	
	private int index;
	private int distance;
	
	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	//getter() -> �ڹ��� ���� : �ܺο��� �ʵ尪�� ���������� �������� ���ϰ� �ϴ°�, 
	//������ ������ ��ü �ܺο��� �����͸� �ٷ�� �����Ͱ� �ջ�� �� �����Ƿ� 
	//�̸� ���� ���� ���� ��ü������ ����
	public int getIndex() {
		return this.index;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	public int compareTo(Node node) {
		return this.distance - node.distance;
	}
	
	public String toString() {
		return "(index :" + index + ", distance :" + distance + ")";  
	}
}
