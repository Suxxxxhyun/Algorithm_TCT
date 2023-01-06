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
	
	public static final int INF = (int)1e9; //Integer.MAX_VALUE = 2147483647(21��); //(int)1e9 = 10�� 
	//int�� ������ +-21���ε�, ����ū ���� 2147483647(21��)���� +1�� �ϸ� ���ĳ���, ���� ���� ������ ���ư�����
	//https://1924.tistory.com/178 -> �����÷ο�, a=2, b=3, k=1�ΰ�츦 �����ϸ�, (2,3) = 7, Math.min(7, 3+����) --> �����÷ο� �߻���
	public static int N,M;//N:����� ����, M:������ ����
	public static int [][] graph = new int[501][501]; //����� ������ �ִ� 500���� �����Ͽ��� ������ 501���� ũ��� 2���� �迭 graph�� ����

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //����� ����
		M = Integer.parseInt(br.readLine()); //������ ����
		
		// �ִ� �Ÿ� ���̺��� ��� �������� �ʱ�ȭ
		for(int i=0; i<501; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		// �ڱ� �ڽſ��� �ڱ� �ڽ����� ���� ����� 0���� �ʱ�ȭ
		for(int a=1; a<=N; a++) {
			for(int b=1; b<=N; b++) {
				if(a==b) {
					graph[a][b] = 0;
				}
			}
		}
		
		// �� ������ ���� ������ �Է� �޾�, �� ������ �ʱ�ȭ -> p258�� ���� �˰�����, 1 2 4�� �Է¹޾Ҵٴ� ����, 1�� ��忡�� 2������ ���� ����� 4��� ���� �ǹ���.
		for(int i=0; i<M; i++) {
			String[] st = br.readLine().split(" ");
			int a = Integer.parseInt(st[0]); //��߳��
			int b = Integer.parseInt(st[1]); //�������
			int c = Integer.parseInt(st[2]); //����ġ
			graph[a][b] = c;
		}
		
		// ��ȭ�Ŀ� ���� �÷��̵� ���� �˰����� ���� -> step1, ���İ��� ��带 1�̶�� �Ѵٸ�, k�� 1�̿�����, graph[1][2], graph[1][1] + graph[1][2]
        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                    //System.out.print(graph[a][b] + " ");
                }
                //System.out.println();
            }
        }
		
		// ����� ����� ���
        for (int a = 1; a <= N; a++) {
            for (int b = 1; b <= N; b++) {
                // ������ �� ���� ���, ����(INFINITY)�̶�� ���
                if (graph[a][b] == INF) {
                    System.out.print("INFINITY");
                }
                // ������ �� �ִ� ��� �Ÿ��� ���
                else {
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }

	}

}
