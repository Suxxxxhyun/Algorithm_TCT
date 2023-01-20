package ThisCodingTest.src.part03.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main311 {

    static int n;
    static PriorityQueue<Integer> a = new PriorityQueue<>(Collections.reverseOrder());
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            a.offer(Integer.parseInt(st.nextToken()));
        }

        pro();
    }

    static void pro(){
        int cnt = 0; //그룹이 최대 십만이므로, int가능

        while(!a.isEmpty()){
            int x = a.peek();

            for(int i=0; i<x; i++){
                a.poll();
            }

            cnt += 1;
        }
        System.out.println(cnt);

    }


}
