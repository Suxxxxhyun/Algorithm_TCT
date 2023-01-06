package part02.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//https://github.com/ndb796/python-for-coding-test/blob/master/5/11.java에서는
//visited배열을 굳이 만들어주지않음
//이유 : 처음 방문을 했는지 이미 방문을 했는지는 1보다 크면 이미 방문한 셈이 되니까 1인 경우에만 bfs가 되도록 수행
class XY{
	private int x;
	private int y;
	
	public XY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}

public class QuestionP152 {
	
	public static int[][] graph = new int[201][201];
	//public static boolean[][] visited = new boolean[201][201];
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int N,M;
	
	public static int bfs(int x, int y) {
		Queue<XY> q = new LinkedList<>();
		q.offer(new XY(x,y));
		//visited[x][y] = true;
		
		while(!q.isEmpty()) {
			XY z = q.poll();
			
			for(int i=0; i<4; i++) {
				int ddx = z.getX() + dx[i];
				int ddy = z.getY() + dy[i];
				
				//애초에 문제조건에 한번에 한칸씩 이동할 수 있기때문에, 상하좌우로밖에 못움직임
				if(ddx <= 0 || ddy <=0 || ddx > N || ddy > M) {
					continue;
				}
				
				//visited배열을 사용하지 않기 위해 -> 방문을 했는지 안했는지를 graph[ddx][ddy] == 1조건으로 알수가 있는데,
				//graph[ddx][ddy] == 1이면 처음 방문해주는 꼴이니까!
				if((graph[ddx][ddy] == 1) && (graph[ddx][ddy] != 0)) {
					q.offer(new XY(ddx, ddy));
					graph[ddx][ddy] += graph[z.getX()][z.getY()];
				}

				/*if((visited[ddx][ddy] == false) && (graph[ddx][ddy] != 0)) {
					q.offer(new XY(ddx, ddy));
					visited[ddx][ddy] = true;
					graph[ddx][ddy] += graph[z.getX()][z.getY()];
				}*/
				
				if(ddx == N && ddy == M) {
					break;
				}
			}
		}
		
		return graph[N][M];
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = br.readLine().split(" ");
		N = Integer.parseInt(str1[0]);
		M = Integer.parseInt(str1[1]);
		
		for(int i=1; i<=N; i++) {
			String str2 = br.readLine();
			for(int j=1; j<=M; j++) {
				graph[i][j] = (int)str2.charAt(j-1) - '0';
			}
		}
		
		System.out.println(bfs(1,1));
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}

}
