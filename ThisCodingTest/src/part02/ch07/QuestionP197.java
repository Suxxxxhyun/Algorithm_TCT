package ThisCodingTest.src.part02.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
5
8 3 7 9 2
3
5 7 9
 */

public class QuestionP197 {
    
    static int n,m; //n�� �ִ� �鸸, m�� �ִ� �ʸ��̹Ƿ� int����
    static int[] a; //�� ���Ҵ� �ִ� �鸸�̹Ƿ� int����
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<m; i++){
            solution(Integer.parseInt(st.nextToken()), 0, n-1);
        }

        Arrays.sort(a); //�鸸log�鸸
        System.out.println(sb);

    }
    
    static void solution(int x,int start, int end){
        if(start > end){
            sb.append("no").append(' ');
            return;
        }
        int mid = (start + end) / 2;
        if(x == a[mid]){
            sb.append("yes").append(' ');
            return;
        } else if(x > a[mid]){
            solution(x, mid+1, end);
        } else {
            solution(x,start, mid-1);
        }

    }
}
