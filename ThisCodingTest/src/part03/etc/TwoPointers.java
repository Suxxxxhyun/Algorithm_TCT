package ThisCodingTest.src.part03.etc;

//�κ��� ����� ��(p472)
public class TwoPointers {

    static int n = 5;
    static int m = 5;
    static int[] a = {1,2,3,2,5};
    public static void main(String[] args) {
        int cnt = 0;
        int intervalSum = 0;
        int end = 0;

        //start�� ���ʴ�� ������Ű�� �ݺ�
        for(int start = 0; start <n; start++){
            //end�� �����Ѹ�ŭ �̵���Ű��
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
