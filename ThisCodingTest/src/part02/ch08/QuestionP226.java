package ThisCodingTest.src.part02.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QuestionP226 {

    static int n,m;
    static StringTokenizer st;
    static int[] d, money;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = new int[m + 1];
        money = new int[n];

        for(int i=0; i<n; i++){
            money[i] = Integer.parseInt(br.readLine());
        }

        pro();
    }

    static void pro(){
        Arrays.fill(d, 10001);
        d[0] = 0;

        for(int i=0; i<n; i++){
            for(int j=money[i]; j<=m; j++){
                //(i-k)원을 만드는 방법이 존재하는 경우
                if(d[j - money[i]] != 10001){
                    d[j] = Math.min(d[j], d[j - money[i]] + 1);
                }
            }
        }

        //계산된 결과출력
        if(d[m] == 10001){
            System.out.println(-1);
        } else {
            System.out.println(d[m]);
        }
    }
}
