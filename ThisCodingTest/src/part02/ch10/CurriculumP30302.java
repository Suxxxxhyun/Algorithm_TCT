package part02.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1
 */

//입력부분 주의(30~37라인 주의해서 다시 복습할것)

public class CurriculumP30302 {

	public static int N;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static int[] time, indegree;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		time = new int[N+1];
		indegree = new int[N+1];
		
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			time[i] = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int b = Integer.parseInt(st.nextToken());
				if(b == -1) {
					break;
				}
				graph.get(b).add(i);
				indegree[i] += 1;
			}
		}
		
		System.out.println(graph);
		for(int i=1; i<=N; i++) {
			System.out.print(indegree[i] + " ");
		}
		System.out.println();
		topologySort();
		
		for(int i=1; i<=N; i++) {
			System.out.println(time[i]);
		}
		
		for(int i=1; i<=N; i++) {
			System.out.print(indegree[i] + " ");
		}
	}
	
	public static void topologySort(){
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i=0; i<graph.get(now).size(); i++) {
				indegree[graph.get(now).get(i)] -= 1;
				if(indegree[graph.get(now).get(i)] == 0) {
					time[graph.get(now).get(i)] += time[now];
					q.offer(graph.get(now).get(i));
				}
			}
		}
	}

}
