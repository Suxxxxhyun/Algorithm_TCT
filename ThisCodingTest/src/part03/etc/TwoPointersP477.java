package ThisCodingTest.src.part03.etc;

/*
���ĵ� �� �迭�� �ϳ��� ���ĵ� �迭�� ��ġ�� ����
TwoPointer���(MergeSort�� �����ϱ� ���� ���)
 */
public class TwoPointersP477 {
    public static void main(String[] args) {
        int[] a = {1,3,5};
        int[] b = {2,4,6,8};
        int n = a.length;
        int m = b.length;

        //��� �迭 �ʱ�ȭ
        int[] result = new int[n+m];
        //i�� a�ε���, j�� b�ε���, k�� ����迭 �ε���
        int i = 0, j = 0, k = 0;

        while(i < n && j < m){
            if(a[i] < b[j]){
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        //����ִ� k�� ������ ��� �־��ֱ�
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
