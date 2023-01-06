package part02.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
 */

public class DisjointSetsP298 {
	
	public static int[] parent = new int[100001];
	public static int N;
	public static int M;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = br.readLine().split(" ");
		N = Integer.parseInt(str1[0]);
		M = Integer.parseInt(str1[1]);
		StringBuilder sb = new StringBuilder();
		
		//�ڱ��ڽ��� �θ� �ǵ��� �ʱ�ȭ
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			String[] str2 = br.readLine().split(" ");
			int d = Integer.parseInt(str2[0]);
			int a = Integer.parseInt(str2[1]);
			int b = Integer.parseInt(str2[2]);
			if(d == 0) {
				union(a,b);
			} else {
				if(find(a) == find(b)) { //��Ʈ��尡 ������ ���� ���տ� �����ִٰ� �Ǵ�. ���ʿ� ��ĥ�� ��Ʈ��带 ������ ��ġ�� ������!
					sb.append("YES").append('\n');
				} else {
					sb.append("NO").append('\n');
				}
				
			}
		}
		
		System.out.println(sb);

	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}
	
	//��Ʈ��尡 ������, �� ���� ���տ� �ִ��� �Ǻ��ϴ� �Լ�
	public static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

}


