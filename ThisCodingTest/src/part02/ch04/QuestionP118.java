package ThisCodingTest.src.part02.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
4 4
1 1 0
1 1 1 1
1 0 0 1
1 1 0 1
1 1 1 1
 */

//���� ����
public class QuestionP118 {

    static int n,m,x,y,direction;
    // �湮�� ��ġ�� �����ϱ� ���� ���� �����Ͽ� 0���� �ʱ�ȭ
    public static int[][] d = new int[50][50];
    // ��ü �� ����
    public static int[][] graph = new int[50][50];
    // ��,��,��,�� ���� ����
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();
    }

    static void turn_left(){
        direction -= 1;
        if(direction == -1){
            direction = 3;
        }
    }

    static void pro(){
        //���� ��ǥ �湮 ó��
        d[x][y] = 1;

        int cnt = 1;
        int turn_time = 0;
        while(true){
            //�������� ȸ��
            turn_left();
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            //ȸ���� ���� ���鿡 ������ ���� ĭ�̸鼭 ������ �Ǿ��ִٸ� �̵�
            if(d[nx][ny] == 0 && graph[nx][ny] == -0){
                d[nx][ny] = 1;
                x = nx;
                y = ny;
                cnt += 1;
                turn_time = 0;
                continue;
            }

            //ȸ���� ���� ���鿡 �̹� ���ðų� �ٴ��ΰ��
            else turn_time += 1;
            // �� ���� ��� �� �� ���� ���
            if(turn_time == 4){
                nx = x - dx[direction];
                ny = y - dy[direction];
                //�ڷ� �� �� �ִٸ� �̵��ϱ�
                if(graph[nx][ny] == 0){
                    x = nx;
                    y = ny;
                }
                // �ڰ� �ٴٷ� �����ִ� ���
                else {
                    break;
                }
                turn_time = 0;
            }

        }
        System.out.println(cnt);
    }
}
