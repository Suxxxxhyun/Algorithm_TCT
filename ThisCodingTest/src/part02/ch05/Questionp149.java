package part02.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Questionp149 {
	
	public static int[][] graph = new int[1001][1001];
	public static int N, M;
	
	public static boolean dfs(int x, int y) {
		
		if(x < 0 || x >= N || y < 0 || y >= M) {
			return false;
		}
		
		if(graph[x][y] == 0) {
			graph[x][y] = 1;
			
			dfs(x, y-1);
			dfs(x, y+1);
			dfs(x-1, y);
			dfs(x+1, y);
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st1 = br.readLine().split(" ");
		N = Integer.parseInt(st1[0]);
		M = Integer.parseInt(st1[1]);
		
		for(int i=0; i<N; i++) {
			String st2 = br.readLine();
			for(int j=0; j<M; j++) {
				graph[i][j] = (int)st2.charAt(j) - '0';
			}
		}
		
		int result = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(dfs(i,j)) {
					result += 1;
				}
			}
		}
		
		System.out.println(result);
	}

}
