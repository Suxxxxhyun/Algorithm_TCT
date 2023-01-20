package ThisCodingTest.src.part03.etc;

//부분합 경우의 수(p472)
public class TwoPointers {

    static int n = 5;
    static int m = 5;
    static int[] a = {1,2,3,2,5};
    public static void main(String[] args) {
        int cnt = 0;
        int intervalSum = 0;
        int end = 0;

        //start를 차례대로 증가시키며 반복
        for(int start = 0; start <n; start++){
            //end를 가능한만큼 이동시키기
            while(intervalSum < m && end < n){
                intervalSum += a[end];
                end += 1;
                //System.out.println(intervalSum + " , " + end);
            }
            if(intervalSum == m){
                cnt += 1;
            }
            intervalSum -= a[start];
        }
        System.out.println(cnt);
    }
}
