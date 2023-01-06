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

//두 원소의 루트노드가 서로 같다면, 즉 같은 집합에 속한다면, 
//두 원소(노드)를 연결하고자 할때 사이클이 발생할 것이라는 것을 알려주는 코드였음!


public class DisjointSetsP279 {
	
	public static int V,E; //노드의 개수:V, 간선의 개수:E
	public static int[] parent = new int[100001]; //노드의 개수는 최대 100,000개라고 가정
	
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
		
		boolean cycle = false; //사이클 발생여부를 판단하는 변수 cycle
		
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
			System.out.println("사이클이 발생했습니다.");
		} else {
			System.out.println("사이클이 발생하지 않았습니다.");
		}
	}

}
