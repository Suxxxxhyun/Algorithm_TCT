package part02.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberCardP97 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //행 = 가로
		int M = Integer.parseInt(st.nextToken()); //열
		int result = 0;
		
		for(int i=0; i<N; i++) {
			int min_value = 10001;
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				int x = Integer.parseInt(st.nextToken());
				min_value = Math.min(min_value, x);
			}
			result = Math.max(result, min_value);
		}
		
		System.out.println(result);
		
	}

}
