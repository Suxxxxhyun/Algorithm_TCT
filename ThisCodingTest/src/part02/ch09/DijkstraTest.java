package part02.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*6 11 1
1 2 2
1 3 5
1 4 1
2 4 2
2 3 3
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2 -> �Է� ����
 */

public class DijkstraTest {
	
	public static final int INF = Integer.MAX_VALUE;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static int[] table = new int[100001]; //�Ÿ�����迭

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str1 = br.readLine().split(" ");
		int N = Integer.parseInt(str1[0]); //����� ����
		int M = Integer.parseInt(str1[1]); //������ ����
		int start = Integer.parseInt(str1[2]); //��������
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<M; i++) {
			String[] str2 = br.readLine().split(" ");
			int node1 = Integer.parseInt(str2[0]);
			int node2 = Integer.parseInt(str2[1]);
			int distance = Integer.parseInt(str2[2]);
			graph.get(node1).add(new Node(node2, distance));
		}
		
		Arrays.fill(table, INF); //Arrays.fill()�� ���� �Ÿ�����迭�� ��� �������� �ʱ�ȭ��Ŵ.
		
		dijkstra(start);
		
		for(int i=1; i<=N; i++) {
			if(table[i] == INF) {
				System.out.println("INFINITY");
			} else {
				System.out.println(table[i]);
			}
		}
	}
	
	public static void dijkstra(int start) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		table[start] = 0; //���������� index�� �ϴ� �Ÿ�����迭�� ���� 0���� ������Ʈ��Ŵ.
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int dist = node.getDistance();
			int vertex = node.getIndex();
			
			if(dist > table[vertex]) {
				continue;
			}
			
			for(int i=0; i<graph.get(vertex).size(); i++) {
				int cost = graph.get(vertex).get(i).getDistance() + dist;
				
				if(cost < table[graph.get(vertex).get(i).getIndex()]) {
					table[graph.get(vertex).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(vertex).get(i).getIndex(), cost));
				}
			}
		}
	}

}
