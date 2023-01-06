package part02.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 3 3
1 2 
1 3
2 3
 */

//�� ������ ��Ʈ��尡 ���� ���ٸ�, �� ���� ���տ� ���Ѵٸ�, 
//�� ����(���)�� �����ϰ��� �Ҷ� ����Ŭ�� �߻��� ���̶�� ���� �˷��ִ� �ڵ忴��!


public class DisjointSetsP279 {
	
	public static int V,E; //����� ����:V, ������ ����:E
	public static int[] parent = new int[100001]; //����� ������ �ִ� 100,000����� ����
	
	public static int findParent(int x) {
		 if (x == parent[x]) {
			 return x;
		 }
	     return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = br.readLine().split(" ");
		V = Integer.parseInt(str1[0]);
		E = Integer.parseInt(str1[1]);
		
		for(int i=1; i<=V; i++) {
			parent[i] = i;
		}
		
		boolean cycle = false; //����Ŭ �߻����θ� �Ǵ��ϴ� ���� cycle
		
		for(int i=0; i<E; i++) {
			String[] str2 = br.readLine().split(" ");
			int a = Integer.parseInt(str2[0]);
			int b = Integer.parseInt(str2[1]);
			if(findParent(a) == findParent(b)) {
				cycle = true;
				break;
			} else {
				unionParent(a,b);
			}
			
		}
		
		if(cycle) {
			System.out.println("����Ŭ�� �߻��߽��ϴ�.");
		} else {
			System.out.println("����Ŭ�� �߻����� �ʾҽ��ϴ�.");
		}
	}

}
