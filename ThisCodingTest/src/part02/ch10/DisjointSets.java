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
각 원소가 속한 집합: 1 1 1 1 5 5 
부모 테이블: 1 1 2 1 5 5 ***/

public class DisjointSets {
	
	public static int V,E; //노드의 개수, 간선(Union 연산)의 개수
	public static int[] parent = new int[100001]; //부모테이블

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		//초기화, 부모테이블에서 자기자신이 부모가 되도록 초기화
		for(int i=1; i<=V; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<E; i++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			unionParent(a,b);
		}
		
		System.out.print("각 원소가 속한 집합: ");
		for(int i=1; i<=V; i++) {
			System.out.print(findParent(i) + " ");
		}
		System.out.println();
		
		System.out.print("부모 테이블: ");
		for(int i=1; i<=V; i++) {
			System.out.print(parent[i] + " ");
		}
		System.out.println();
	}
	
	
	//두개의 원소가 주어졌을때 각각 같은 집합에 포함되어있는지의 여부, 특정한 원소가 속한 집합이 어떤 집합인지 알려주는 연산, 루트노드를 확인하는 메서드 -> 루트노드가 같다면 같은 집합에 속해있음.
	public static int findParent(int x) {
		if(x == parent[x]) {
			return x;
		} 
		return parent[x] = findParent(parent[x]);
	}
	
	//두 원소가 각각 포함되어있는 집합이 하나의 집합이 될 수 있도록 합치는 메서드
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
