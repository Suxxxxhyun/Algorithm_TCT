package ThisCodingTest.src.part02.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionP201 {

    static int n,m, ans, result = 0; //n은 떡의 개수(최대 백만), m은 떡의 길이(최대 2십억)이므로 int가능, ans는 높이의 최댓값을 담는 변수로, 최대 십억까지 가능하므로 int가능,
    //sum(잘린떡의 총길이) = 100만개의 떡이 모두 십억이라고 가정하고, 내가 만약 높이 1만큼 잘랐다면, 대략 100만개 * 십억 이므로 -> long에 담아줄 것임
    //result => mid를 저장하는 변수
    static long sum;
    static int[] heights; //떡의 개별 높이는 최대 십억이므로 int타입가능
    static StringTokenizer st;
    static int max = Integer.MIN_VALUE; // max => 가지고 있는 떡중 높이가 가장 큰 놈을 받아주는 받아주는 변수, 최대 십억이므로 int가능
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
            if(heights[i] > mid){ //**중요
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
