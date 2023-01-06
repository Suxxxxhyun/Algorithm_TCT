package part02.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//이코테 미래도시
//방문 판매원 A가 1번에서 시작한다고 하였기 때문에, 모든 노드에서 모든 노드로 생각할 필요가 없어서 플로이드 워셜 알고리즘이라고 할 수가 있나?
//p260을 보면, N의 범위가 어차피 100이하로 한정적이며, 플로이드 워셜 알고리즘을 이용해도 빠르게 풀수 있기 때문에,
//구현이 간단한 플로이드 워셜 알고리즘으로 접근하는게 맞다고 책에서 나와있음.

//1번회사에서 출발하여 K번 회사를 방문한 뒤에 X번 회사로 가는 것이 목표임.

/*
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
 */

/*
4 2
1 3
2 4
3 4
 */

public class FutureCity {
	
	public static final int INF = (int)1e9;
	public static int [][] graph = new int[101][101]; //N의 범위가 100이하이기 때문에 101로 설정

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st1 = br.readLine().split(" ");
		
		//무한으로 초기화
		for(int i=0; i<101; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		int N = Integer.parseInt(st1[0]); //회사의 개수 = 노드의 개수
		int M = Integer.parseInt(st1[1]); //경로의 개수 = 간선의 개수
		
		for(int i=0; i<M; i++) {
			String[] st2 = br.readLine().split(" ");
			int Node1 = Integer.parseInt(st2[0]); //특정 회사의 출발번호
			int Node2 = Integer.parseInt(st2[1]); //특정 회사의 도착번호
			graph[Node1][Node2] = 1;
			graph[Node2][Node1] = 1;
		}
		
		String[] st3 = br.readLine().split(" ");
		int X = Integer.parseInt(st3[0]); //x번 회사
		int K = Integer.parseInt(st3[1]); //k번 회사
		
		//N의 시작범위가 1부터이기때문에 0은 생각할 필요가 없음. 자기 자신에서 자기자신으로 가는 비용 0으로 초기화
		for(int i=1; i<graph.length; i++) {
			for(int j=1; j<graph[i].length; j++) {
				if(i == j) {
					graph[i][j] = 0;
				}
			}
		}
		
		//점화식에 따라 플로이드워셜 알고리즘 구현, 1번 회사에서 K번회사까지 
		for(int k=1; k<=N; k++) {
			for(int a=1; a<=N; a++) {
				for(int b=1; b<=N; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}
		
		int DAK = graph[1][K];
		
		int DKX = graph[K][X];
		
		if(DAK == INF || DKX == INF) {
			System.out.println(-1);
		} else {
			System.out.println(DAK + DKX);
		}
		
	}

}
