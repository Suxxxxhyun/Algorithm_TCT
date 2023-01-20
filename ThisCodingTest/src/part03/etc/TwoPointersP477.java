package ThisCodingTest.src.part03.etc;

/*
정렬된 두 배열을 하나의 정렬된 배열로 합치기 위해
TwoPointer사용(MergeSort를 개선하기 위한 방법)
 */
public class TwoPointersP477 {
    public static void main(String[] args) {
        int[] a = {1,3,5};
        int[] b = {2,4,6,8};
        int n = a.length;
        int m = b.length;

        //결과 배열 초기화
        int[] result = new int[n+m];
        //i는 a인덱스, j는 b인덱스, k는 결과배열 인덱스
        int i = 0, j = 0, k = 0;

        while(i < n && j < m){
            if(a[i] < b[j]){
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        //비어있는 k의 나머지 모두 넣어주기
        while(i < n){
            result[k++] = a[i++];
        }
        while(j < m){
            result[k++] = b[j++];
        }

        for(int e : result){
            System.out.print(e + " ");
        }
    }
}
