package ThisCodingTest.src.part02.ch09;

import java.io.*;
import java.util.*;

//�ִܰŸ����̺� �Ÿ��� �����ϸ�, �湮���� ���� ����߿��� �ִܰŸ��� ���� ª�� ��带 �����ϱ� ����
//����Ž���� �����Ѵ�.
//��� ��忡 ���ؼ� ����Ž���� �����Ѵ���, �ִܰŸ����̺��� �������ִ� �۾��� ��ġ�Ƿ�, O(V^2)�� �ð����⵵�� �ҿ��Ѵ�.
public class SimpleDijkstra {

    static final int INF = Integer.MAX_VALUE;
    static StringTokenizer st;
    //n�� ����ǰ���, m�� ������ ����, start�� ���۳��
    static int n,m,start;
    static ArrayList<Node>[] graph;
    //����� ������ �ִ� 10������� ����
    static boolean[] visited = new boolean[100001];
    static int[] d = new int[100001];

    static class Node{
        int index, distance;

        public Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<Node>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, cost));
        }

        Arrays.fill(d, INF);

        dijkstra(start);
    }

    //�湮���� ���� ����߿���, �ִܰŸ��� ���� ª�� ����� ��ȣ�� ��ȯ(����Ž��)
    public static int getSmallestNode(){
        int min_value = INF;
        int index = 0;
        for(int i=1; i<=n; i++){
            if(d[i] < min_value && !visited[i]){
                min_value = d[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int start){
        //���� ��忡 ���ؼ� �ʱ�ȭ (���۳�忡�� ���۳������� ����� 0�̱⶧��)
        d[start] = 0;
        visited[start] = true;
        for(int j=0; j<graph[start].size(); j++){
            d[graph[start].get(j).index] = graph[start].get(j).distance;
        }

        //���۳�带 ������ ��ü n-1���� ��忡 ���� �ݺ�
        for(int i=0; i<n-1; i++){
            int now = getSmallestNode();
            visited[now] = true;
            //���� ���� ����� �ٸ� ��带 Ȯ��
            for(int j=0; j<graph[now].size(); j++){
                int cost = d[now] + graph[now].get(j).distance;
                if(cost < d[graph[now].get(j).index]){
                    d[graph[now].get(j).index] = cost;
                }
            }
        }
    }
}
