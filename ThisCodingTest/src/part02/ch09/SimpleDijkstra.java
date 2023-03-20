package ThisCodingTest.src.part02.ch09;

import java.io.*;
import java.util.*;

//최단거리테이블에 거리만 저장하며, 방문하지 않은 노드중에서 최단거리가 가장 짧은 노드를 선택하기 위해
//선형탐색을 수행한다.
//모든 노드에 대해서 선형탐색을 수행한다음, 최단거리테이블을 갱신해주는 작업을 거치므로, O(V^2)의 시간복잡도를 소요한다.
public class SimpleDijkstra {

    static final int INF = Integer.MAX_VALUE;
    static StringTokenizer st;
    //n은 노드의개수, m은 간선의 개수, start는 시작노드
    static int n,m,start;
    static ArrayList<Node>[] graph;
    //노드의 개수를 최대 10만개라고 가정
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

    //방문하지 않은 노드중에서, 최단거리가 가장 짧은 노드의 번호를 반환(선형탐색)
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
        //시작 노드에 대해서 초기화 (시작노드에서 시작노드까지의 비용은 0이기때문)
        d[start] = 0;
        visited[start] = true;
        for(int j=0; j<graph[start].size(); j++){
            d[graph[start].get(j).index] = graph[start].get(j).distance;
        }

        //시작노드를 제외한 전체 n-1개의 노드에 대해 반복
        for(int i=0; i<n-1; i++){
            int now = getSmallestNode();
            visited[now] = true;
            //현재 노드와 연결된 다른 노드를 확인
            for(int j=0; j<graph[now].size(); j++){
                int cost = d[now] + graph[now].get(j).distance;
                if(cost < d[graph[now].get(j).index]){
                    d[graph[now].get(j).index] = cost;
                }
            }
        }
    }
}
