package part02.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionP115 {
	
	public static int[][] graph = new int[9][9];
	public static String str;
	public static int col, row;
	public static int count = 0;
	public static int[] dx = {-2,-2,2,2,-1,1,-1,1};
	public static int[] dy = {-1,1,-1,1,2,2,-2,-2}; //열
	//public static char[] moveTypes = {'A','B','C','D','E','F','E','F'};

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		
		//a의 아스키코드값이 97이기때문에 1을 만들어주기위해 96을 뻄
		col = (int)str.charAt(0) - 96;
		row = str.charAt(1) - '0';
		//(1,1)
		move();
		System.out.println(count);
	}
	
	public static void move() {
		
		for(int i=0; i<8; i++) {
			int nx = 0, ny = 0;
			
			nx = row + dx[i];
			ny = col + dy[i];
			
			if(nx <= 0 || ny <= 0 || nx > 9 || ny > 9) {
				continue;
			}
			
			count++;
		}
		
		
		
	}

}
