package ThisCodingTest.src.part02.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class QuestionP197Set {

    static Set<Integer> s = new HashSet<Integer>();
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            s.add(Integer.parseInt(st.nextToken()));
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<m; i++){
            if(s.contains(Integer.parseInt(st.nextToken()))){
                sb.append("yes").append(' ');
            } else {
                sb.append("no").append(' ');
            }
        }

        System.out.println(sb);
    }
}
