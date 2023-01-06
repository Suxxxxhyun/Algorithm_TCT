package part02.ch05;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS {
	
	public static boolean[] visited = new boolean[9];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	public static void dfs(int x) {
		//현재 노드를 방문 처리
		visited[x] = true;
		System.out.print(x + " ");
		
		for(int i=0; i<graph.get(x).size(); i++) {
			int y = graph.get(x).get(i);
			if(!visited[y]) {
				dfs(y);
			}
		}
	}

	public static void main(String[] args) {
		
		for(int i=0; i<9; i++) {
			graph.add(new ArrayList<Integer>());
			//System.out.println(visited[i]);
		}
		
		graph.get(1).addAll(Arrays.asList(2,3,8));
		graph.get(2).addAll(Arrays.asList(1,7));
		graph.get(3).addAll(Arrays.asList(1,4,5));
		graph.get(4).addAll(Arrays.asList(3,5));
		graph.get(5).addAll(Arrays.asList(3,4));
		graph.get(6).addAll(Arrays.asList(7));
		graph.get(7).addAll(Arrays.asList(2,6,8));
		graph.get(8).addAll(Arrays.asList(1,7));
		
		dfs(1);
	}

}
