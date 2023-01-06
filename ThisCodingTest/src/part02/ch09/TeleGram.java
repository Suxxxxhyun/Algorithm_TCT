package part02.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class TeleGram {
	
	public static final int INF = Integer.MAX_VALUE;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static int[] table = new int[30001];

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = br.readLine().split(" ");
		int N = Integer.parseInt(str1[0]); //도시의 개수
		int M = Integer.parseInt(str1[1]); //통로의 개수
		int C = Integer.parseInt(str1[2]); //메시지를 보내고자 하는 도시
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<M; i++) {
			String[] str2 = br.readLine().split(" ");
			int X = Integer.parseInt(str2[0]);
			int Y = Integer.parseInt(str2[1]);
			int Z = Integer.parseInt(str2[2]);
			
			graph.get(X).add(new Node(Y,Z));
		}
		
		Arrays.fill(table, INF);
		int city = dijkstra(graph, C);
	
		int time = 0;
		
		for(int i=1; i<=N; i++) {
			if(i==N) {
				break;
			}
			if(table[i] == INF) {
				table[i] = 0;
			}
			time = Math.max(table[i], table[i+1]);
		}
		System.out.print(city + " " + time);
	}
	
	public static int dijkstra(ArrayList<ArrayList<Node>> graph, int start) {
		
		table[start] = 0;
		PriorityQueue<Node02> pq = new PriorityQueue<Node02>();
		pq.offer(new Node02(start,0));
		int city = 0;
		
		while(!pq.isEmpty()) {
			Node02 node = pq.poll();
			int pollNodeIndex = node.getIndex(); //1
			int pollNodeDistance = node.getDistance(); //0
			
			if(table[pollNodeIndex] < pollNodeDistance) {
				continue;
			}
			
			for(int i=0; i<graph.get(pollNodeIndex).size(); i++) {
				int weight = pollNodeDistance + graph.get(pollNodeIndex).get(i).getDistance();
				if(table[graph.get(pollNodeIndex).get(i).getIndex()] > weight) {
					table[graph.get(pollNodeIndex).get(i).getIndex()] = weight;
					city++;
					pq.offer(new Node02(graph.get(pollNodeIndex).get(i).getIndex(), weight));
				}
			}
		}
		
		return city;
	}

}

class Node02 implements Comparable<Node02>{
	private int index;
	private int distance;
	
	public Node02(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	public int compareTo(Node02 node) {
		return this.distance - node.distance;
	}
	
	public String toString() {
		return "(" + index + "," + distance + ")";
	}
}
