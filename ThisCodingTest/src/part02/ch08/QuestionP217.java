package ThisCodingTest.src.part02.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionP217 {

    static int x;
    static int[] d  = new int[30001];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());

        for(int i=2; i<=x; i++){
            //현재의 수에서 1을 빼는 경우
            d[i] = d[i - 1] + 1;
            //현재의 수가 2로 나누어떨어지는 경우
            if(i % 2 == 0){
                d[i] = Math.min(d[i], d[i / 2] + 1);
            }
            //현재의 수가 3으로 나누어떨어지는 경우
            if(i % 3 == 0){
                d[i] = Math.min(d[i], d[i / 3] + 1);
            }
            //현재의 수가 5로 나누어 떨어지는 경우
            if(i % 5 == 0){
                d[i] = Math.min(d[i], d[i / 5] + 1);
            }
            System.out.println(d[x]);
        }
    }

}
