package part02.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
7 8
1 2
1 5
2 3
2 6
3 4
4 7
5 6
6 4
 */

public class TopologySortP296 {
	
	// ����� ����(V)�� ������ ����(E)
    // ����� ������ �ִ� 100,000����� ����
    public static int v, e;
    // ��� ��忡 ���� ���������� 0���� �ʱ�ȭ
    public static int[] indegree = new int[100001];
    public static String[] str1, str2;
    // �� ��忡 ����� ���� ������ ��� ���� ���� ����Ʈ �ʱ�ȭ
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    
    // ���� ���� �Լ�
    public static void topologySort() {
        ArrayList<Integer> result = new ArrayList<>(); // �˰��� ���� ����� ���� ����Ʈ
        Queue<Integer> q = new LinkedList<>(); // ť ���̺귯�� ���

        // ó�� ������ ���� ���������� 0�� ��带 ť�� ����
        for (int i = 1; i <= v; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // ť�� �� ������ �ݺ�
        while (!q.isEmpty()) {
            // ť���� ���� ������
            int now = q.poll();
            result.add(now);
            // �ش� ���ҿ� ����� ������ ������������ 1 ����
            for (int i = 0; i < graph.get(now).size(); i++) {
                indegree[graph.get(now).get(i)] -= 1;
                // ���Ӱ� ���������� 0�� �Ǵ� ��带 ť�� ����
                if (indegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                    //offer�� ����ó�� ����� ���Ե� �޼����̰�, add�� ����ó������� �����Ե� �޼����̴� offer�� �������
                }
            }
        }

        // ���� ������ ������ ��� ���
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }


	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine().split(" ");
		v = Integer.parseInt(str1[0]);
		e = Integer.parseInt(str1[1]);
		
		// �׷��� �ʱ�ȭ
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // ���� �׷����� ��� ���� ������ �Է� �ޱ�
        for (int i = 0; i < e; i++) {
        	str2 = br.readLine().split(" ");
            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);
            graph.get(a).add(b); // ���� A���� B�� �̵� ����
            // ���� ������ 1 ����
            indegree[b] += 1;
        }
        
        for(int i=1; i<=v; i++) {
        	System.out.print(indegree[i] + " ");
        }
        System.out.println();
        
        topologySort();
	}

}
