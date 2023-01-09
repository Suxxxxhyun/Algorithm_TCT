package ThisCodingTest.src.part02.ch08;

public class fibonacciForloop {

    public static long[] d = new long[100];
    public static void main(String[] args) {

        d[1] = 1;
        d[2] = 1;
        int n = 50;

        // 피보나치 함수(Fibonacci Function) 반복문으로 구현(보텀업 다이나믹 프로그래밍)
        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        System.out.println(d[n]);
    }
}
