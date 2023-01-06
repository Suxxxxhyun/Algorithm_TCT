package part02.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GameDevelopmentP118 {
	
	public static int N,M,A,B,d,count;
	public static StringTokenizer st;
	public static int[][] graph;
	public static boolean[][] visited;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};
	public static int[] direction = {3,2,1,0}; //서,남,동,북

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken()); //행
		B = Integer.parseInt(st.nextToken()); //열
		d = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		visited = new boolean[N][M];
		count = 0;
		
		for(int i=0; i<graph.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<graph[i].length; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		move();
		System.out.println(count);
	}

	public static void move() {
		int x = -1;
		int y = -1;
		visited[A][B] = true;
		while(true) {
			turnLeft(); //-> d의 값이 3, 0
			for(int i=0; i<4; i++) {
				x = dx[i] + A; //1 //2
				y = dy[i] + B; //0 //1
				if(x >= N || y >= M || x < 0 || y < 0) {
					continue;
				}
				if(graph[x][y] == 1 || visited[x][y] == true) {
					continue;
				} 
				A = x;
				B = y;
				visited[A][B] = true;
				d = direction[i]; //d의 값이 1, 2
				count++;
			}
			
		}
	}
	
	public static void turnLeft() {
		for(int i=0; i<4; i++) {
			if(i == 3) {
				d = direction[0];
				if(d == direction[i]) {
					d = direction[i+1];
				}
			}
			break;
		}
	}

}
