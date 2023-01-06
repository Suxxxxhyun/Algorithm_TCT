package part02.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class KruskalAlgorithmP288 {
	
	public static int V,E; //노드의 개수, 간선의 개수
	public static int[] parent = new int [100001];
	//우선순위큐 PriorityQueue<Edge> edges 로 선언하면 나중에 따로 정렬하지 않아도 되어서 시간복잡도를 낮출 수 있음.
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
		//사실 a = parent[a]로 해도 상관없음. 왜냐면 parent테이블이 부모노드 값이 아닌 루트노드가 되도록, union전에 if문의 조건문을 통해 갱신이 되고 있기 떄문!
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
