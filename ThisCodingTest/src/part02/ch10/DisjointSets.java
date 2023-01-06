package part02.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***6 4
1 4 
2 3
2 4
5 6
�� ���Ұ� ���� ����: 1 1 1 1 5 5 
�θ� ���̺�: 1 1 2 1 5 5 ***/

public class DisjointSets {
	
	public static int V,E; //����� ����, ����(Union ����)�� ����
	public static int[] parent = new int[100001]; //�θ����̺�

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		//�ʱ�ȭ, �θ����̺��� �ڱ��ڽ��� �θ� �ǵ��� �ʱ�ȭ
		for(int i=1; i<=V; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<E; i++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			unionParent(a,b);
		}
		
		System.out.print("�� ���Ұ� ���� ����: ");
		for(int i=1; i<=V; i++) {
			System.out.print(findParent(i) + " ");
		}
		System.out.println();
		
		System.out.print("�θ� ���̺�: ");
		for(int i=1; i<=V; i++) {
			System.out.print(parent[i] + " ");
		}
		System.out.println();
	}
	
	
	//�ΰ��� ���Ұ� �־������� ���� ���� ���տ� ���ԵǾ��ִ����� ����, Ư���� ���Ұ� ���� ������ � �������� �˷��ִ� ����, ��Ʈ��带 Ȯ���ϴ� �޼��� -> ��Ʈ��尡 ���ٸ� ���� ���տ� ��������.
	public static int findParent(int x) {
		if(x == parent[x]) {
			return x;
		} 
		return parent[x] = findParent(parent[x]);
	}
	
	//�� ���Ұ� ���� ���ԵǾ��ִ� ������ �ϳ��� ������ �� �� �ֵ��� ��ġ�� �޼���
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}

}
