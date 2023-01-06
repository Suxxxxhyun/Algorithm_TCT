package ThisCodingTest.src.part02.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionP197CountingSort {

    static int n,m;
    static int[] a = new int[1000001];
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            a[Integer.parseInt(st.nextToken())]++;
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<m; i++){
            if(a[Integer.parseInt(st.nextToken())] >= 1){
                sb.append("yes").append(' ');
            } else {
                sb.append("no").append(' ');
            }
        }

        System.out.println(sb);
    }
}
