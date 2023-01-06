package part02.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//������ �̷�����
//�湮 �Ǹſ� A�� 1������ �����Ѵٰ� �Ͽ��� ������, ��� ��忡�� ��� ���� ������ �ʿ䰡 ��� �÷��̵� ���� �˰����̶�� �� ���� �ֳ�?
//p260�� ����, N�� ������ ������ 100���Ϸ� �������̸�, �÷��̵� ���� �˰����� �̿��ص� ������ Ǯ�� �ֱ� ������,
//������ ������ �÷��̵� ���� �˰������� �����ϴ°� �´ٰ� å���� ��������.

//1��ȸ�翡�� ����Ͽ� K�� ȸ�縦 �湮�� �ڿ� X�� ȸ��� ���� ���� ��ǥ��.

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
	public static int [][] graph = new int[101][101]; //N�� ������ 100�����̱� ������ 101�� ����

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st1 = br.readLine().split(" ");
		
		//�������� �ʱ�ȭ
		for(int i=0; i<101; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		int N = Integer.parseInt(st1[0]); //ȸ���� ���� = ����� ����
		int M = Integer.parseInt(st1[1]); //����� ���� = ������ ����
		
		for(int i=0; i<M; i++) {
			String[] st2 = br.readLine().split(" ");
			int Node1 = Integer.parseInt(st2[0]); //Ư�� ȸ���� ��߹�ȣ
			int Node2 = Integer.parseInt(st2[1]); //Ư�� ȸ���� ������ȣ
			graph[Node1][Node2] = 1;
			graph[Node2][Node1] = 1;
		}
		
		String[] st3 = br.readLine().split(" ");
		int X = Integer.parseInt(st3[0]); //x�� ȸ��
		int K = Integer.parseInt(st3[1]); //k�� ȸ��
		
		//N�� ���۹����� 1�����̱⶧���� 0�� ������ �ʿ䰡 ����. �ڱ� �ڽſ��� �ڱ��ڽ����� ���� ��� 0���� �ʱ�ȭ
		for(int i=1; i<graph.length; i++) {
			for(int j=1; j<graph[i].length; j++) {
				if(i == j) {
					graph[i][j] = 0;
				}
			}
		}
		
		//��ȭ�Ŀ� ���� �÷��̵���� �˰��� ����, 1�� ȸ�翡�� K��ȸ����� 
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
