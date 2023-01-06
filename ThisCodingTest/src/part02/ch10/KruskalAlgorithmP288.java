package part02.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class KruskalAlgorithmP288 {
	
	public static int V,E; //����� ����, ������ ����
	public static int[] parent = new int [100001];
	//�켱����ť PriorityQueue<Edge> edges �� �����ϸ� ���߿� ���� �������� �ʾƵ� �Ǿ �ð����⵵�� ���� �� ����.
	public static ArrayList<Edge> edges = new ArrayList<Edge>();
	public static int result = 0;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		V = Integer.parseInt(str[0]);
		E = Integer.parseInt(str[1]);
		
		for(int i=1; i<=V; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges.add(new Edge(a,b,weight));
		}
		
		Collections.sort(edges);
		
		for(int i=0; i<edges.size(); i++) {
			int nodeA = edges.get(i).getNodeA();
			int nodeB = edges.get(i).getNodeB();
			int cost = edges.get(i).getDistance();
			
			if(findParent(nodeA) != findParent(nodeB)) {
				unionParent(nodeA, nodeB);
				result += cost;
			}

		}
		
		System.out.println(result);
	}
	
	public static int findParent(int x) {
		if(parent[x] == x) {
			return x;
		} 
		return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b); 
		//��� a = parent[a]�� �ص� �������. �ֳĸ� parent���̺��� �θ��� ���� �ƴ� ��Ʈ��尡 �ǵ���, union���� if���� ���ǹ��� ���� ������ �ǰ� �ֱ� ����!
		if(a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}

}

class Edge implements Comparable<Edge>{
	
	private int distance;
	private int nodeA;
	private int nodeB;
	
	public Edge(int distance, int nodeA, int nodeB) {
		this.distance = distance;
		this.nodeA = nodeA;
		this.nodeB = nodeB;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	public int getNodeA() {
		return this.nodeA;
	}
	
	public int getNodeB() {
		return this.nodeB;
	}
	
	public int compareTo(Edge edge) {
		return this.distance - edge.distance;
	}
}
