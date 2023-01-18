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
            //������ ������ 1�� ���� ���
            d[i] = d[i - 1] + 1;
            //������ ���� 2�� ����������� ���
            if(i % 2 == 0){
                d[i] = Math.min(d[i], d[i / 2] + 1);
            }
            //������ ���� 3���� ����������� ���
            if(i % 3 == 0){
                d[i] = Math.min(d[i], d[i / 3] + 1);
            }
            //������ ���� 5�� ������ �������� ���
            if(i % 5 == 0){
                d[i] = Math.min(d[i], d[i / 5] + 1);
            }
            System.out.println(d[x]);
        }
    }

}
