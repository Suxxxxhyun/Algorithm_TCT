package ThisCodingTest.src.part02.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionP201 {

    static int n,m, ans, result = 0; //n�� ���� ����(�ִ� �鸸), m�� ���� ����(�ִ� 2�ʾ�)�̹Ƿ� int����, ans�� ������ �ִ��� ��� ������, �ִ� �ʾ���� �����ϹǷ� int����,
    //sum(�߸����� �ѱ���) = 100������ ���� ��� �ʾ��̶�� �����ϰ�, ���� ���� ���� 1��ŭ �߶��ٸ�, �뷫 100���� * �ʾ� �̹Ƿ� -> long�� ����� ����
    //result => mid�� �����ϴ� ����
    static long sum;
    static int[] heights; //���� ���� ���̴� �ִ� �ʾ��̹Ƿ� intŸ�԰���
    static StringTokenizer st;
    static int max = Integer.MIN_VALUE; // max => ������ �ִ� ���� ���̰� ���� ū ���� �޾��ִ� �޾��ִ� ����, �ִ� �ʾ��̹Ƿ� int����
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        heights = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            int a = Integer.parseInt(st.nextToken());
            heights[i] = a;
            max = Math.max(a, max);
        }

        solution(0,max);
    }

    static void solution(int start, int end){
        
        if(start > end){
            System.out.println(result);
            return;
        }

        int mid = (start + end) / 2;
        sum = 0;

        for(int i=0; i<n; i++){
            if(heights[i] > mid){ //**�߿�
                sum += heights[i] - mid;
            }
        }

        if(sum > m){
            result = mid;
            solution(mid+1, end);
        } else {
            result = mid;
            solution(start, mid-1);
        }
    }
}
