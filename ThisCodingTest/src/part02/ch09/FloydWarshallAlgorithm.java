package part02.ch09;

/*4
7
1 2 4
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4
4 3 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FloydWarshallAlgorithm {
	
	public static final int INF = (int)1e9; //Integer.MAX_VALUE = 2147483647(21억); //(int)1e9 = 10억 
	//int의 범위는 +-21억인데, 가장큰 값인 2147483647(21억)에서 +1을 하면 넘쳐나서, 가장 작은 값으로 돌아가버림
	//https://1924.tistory.com/178 -> 오버플로우, a=2, b=3, k=1인경우를 생각하면, (2,3) = 7, Math.min(7, 3+무한) --> 오버플로우 발생함
	public static int N,M;//N:노드의 개수, M:간선의 개수
	public static int [][] graph = new int[501][501]; //노드의 개수를 최대 500개로 가정하였기 때문에 501개의 크기로 2차원 배열 graph를 생성

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //노드의 개수
		M = Integer.parseInt(br.readLine()); //간선의 개수
		
		// 최단 거리 테이블을 모두 무한으로 초기화
		for(int i=0; i<501; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		// 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
		for(int a=1; a<=N; a++) {
			for(int b=1; b<=N; b++) {
				if(a==b) {
					graph[a][b] = 0;
				}
			}
		}
		
		// 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화 -> p258을 보면 알겠지만, 1 2 4를 입력받았다는 것은, 1번 노드에서 2번노드로 가는 비용이 4라는 것을 의미함.
		for(int i=0; i<M; i++) {
			String[] st = br.readLine().split(" ");
			int a = Integer.parseInt(st[0]); //출발노드
			int b = Integer.parseInt(st[1]); //도착노드
			int c = Integer.parseInt(st[2]); //가중치
			graph[a][b] = c;
		}
		
		// 점화식에 따라 플로이드 워셜 알고리즘을 수행 -> step1, 거쳐가는 노드를 1이라고 한다면, k가 1이였을때, graph[1][2], graph[1][1] + graph[1][2]
        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                    //System.out.print(graph[a][b] + " ");
                }
                //System.out.println();
            }
        }
		
		// 수행된 결과를 출력
        for (int a = 1; a <= N; a++) {
            for (int b = 1; b <= N; b++) {
                // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
                if (graph[a][b] == INF) {
                    System.out.print("INFINITY");
                }
                // 도달할 수 있는 경우 거리를 출력
                else {
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }

	}

}
