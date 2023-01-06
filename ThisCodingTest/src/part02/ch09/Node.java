package part02.ch09;

public class Node implements Comparable<Node>{
	
	private int index;
	private int distance;
	
	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	//getter() -> 자바의 은닉 : 외부에서 필드값을 직접적으로 변경주지 못하게 하는것, 
	//데이터 은닉은 객체 외부에서 데이터를 다루면 데이터가 손상될 수 있으므로 
	//이를 막기 위해 나온 객체지향의 개념
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
