package part02.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UnitlBecomes102 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int count = 0;
		
		while(true) {
			if(N == 1) {
				System.out.println(count);
				break;
			}
			if(N % K == 0) {
				N = N / K;
				count++;
			} else {
				N--;
				count++;
			}
		}
	}

}
