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

//구현 실패
public class QuestionP118 {

    static int n,m,x,y,direction;
    // 방문한 위치를 저장하기 위한 맵을 생성하여 0으로 초기화
    public static int[][] d = new int[50][50];
    // 전체 맵 정보
    public static int[][] graph = new int[50][50];
    // 북,동,남,서 방향 정의
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
        //현재 좌표 방문 처리
        d[x][y] = 1;

        int cnt = 1;
        int turn_time = 0;
        while(true){
            //왼쪽으로 회전
            turn_left();
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            //회전한 이후 정면에 가보지 않은 칸이면서 육지로 되어있다면 이동
            if(d[nx][ny] == 0 && graph[nx][ny] == -0){
                d[nx][ny] = 1;
                x = nx;
                y = ny;
                cnt += 1;
                turn_time = 0;
                continue;
            }

            //회전한 이후 정면에 이미 가봤거나 바다인경우
            else turn_time += 1;
            // 네 방향 모두 갈 수 없는 경우
            if(turn_time == 4){
                nx = x - dx[direction];
                ny = y - dy[direction];
                //뒤로 갈 수 있다면 이동하기
                if(graph[nx][ny] == 0){
                    x = nx;
                    y = ny;
                }
                // 뒤가 바다로 막혀있는 경우
                else {
                    break;
                }
                turn_time = 0;
            }

        }
        System.out.println(cnt);
    }
}
