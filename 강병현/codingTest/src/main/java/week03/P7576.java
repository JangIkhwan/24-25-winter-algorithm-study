package week03;

/*
* BOJ7576 - 토마토
* 주제 - BFS
*
* 풀이 과정
*   Point 클래스에 seq 변수를 둬서 날짜를 체크했습니다.
*   처음 익은 토마토들을 큐에 넣고
*   그 후 큐의 원소들을 꺼내며 BFS를 했습니다.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 가로
        int N = Integer.parseInt(st.nextToken()); // 세로

        int[][] storage = new int[N][M];
        int total = N*M;
        Queue<Point> queue = new LinkedList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                // 0 익지않음, 1 익음, -1 토마토 없음
                int a = Integer.parseInt(st.nextToken());
                storage[i][j] = a;
                if(a == 1){ // 토마토 위치
                    queue.add(new Point(i, j, 0));
                    total-=1;
                }
                if(a == -1)
                    total-=1;
            }
        }

        if(total == 0) { // 처음부터 다 익은 경우
            System.out.println(0);
            return;
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int day = 0;
        while(!queue.isEmpty()){
            Point present = queue.poll();
            //System.out.println("x: " + present.x + " y: " + present.y);
            for(int i = 0; i < 4; i++){ // 4면 검사
                int x = present.x + dx[i];
                int y = present.y + dy[i];
                if(x < 0 || x >= N) continue;
                if(y < 0 || y >= M) continue;
                if(storage[x][y] == 0) {
                    storage[x][y] = 1;
                    queue.add(new Point(x, y, present.day+1));
                    total-=1;
                    if(day < present.day + 1)
                        day = present.day + 1;

                    //System.out.println("day:" + (present.day + 1) + " x " + x + " y " + y);
                }
            }

        }

        if(total != 0) // 다 익지 않은 상황
            System.out.println(-1);
        else // 정상
            System.out.println(day);

    }



    static class Point{

        int x;
        int y;
        int day;

        public Point(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}
