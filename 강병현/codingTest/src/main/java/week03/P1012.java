package week03;

/*
* BOJ1012 - 유기농 배추
* 주제 - DFS or BFS
*
* 풀이 과정
*     좌표 입력을 받은 후 땅 배열을 순회하면서
*     배추가 심어진 땅(1)을 발견할 때마다
*     상하좌우 살피면서 DFS로 영역을 구한다.
*     영역은 count 변수로 했다.
*
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P1012 {

    static int N;
    static int M;
    static int K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int i = 0; i < T; i++){ // 테스트 개수

            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            K = Integer.parseInt(st.nextToken()); // 배추 개수

            int[][] cabbagePatch = new int[N][M]; // 배추(방향 그래프)
//            int[][] isVisited = new int[M][N]; // 방문이력(방향 그래프)
            int x, y;

            for(int j = 0; j < K; j++) { // 배추 땅
                st = new StringTokenizer(br.readLine());
                y = Integer.parseInt(st.nextToken());
                x = Integer.parseInt(st.nextToken());
                cabbagePatch[x][y] = 1;
                //System.out.println("x: " + x + " y: " + y);
            }

            // DFS
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            int count = 0;
            Stack<Point> stack = new Stack<>();
            for(int j = 0; j < N; j++){ // M(가로) N(세로) K
                for(int k = 0; k < M; k++){
                    if(cabbagePatch[j][k] == 1){
                        stack.add(new Point(j, k));
                        while(!stack.isEmpty()) { // dfs
                            Point point = stack.pop();
                            cabbagePatch[point.x][point.y] = 2;
                            for (int z = 0; z < 4; z++) {
                                int newX = point.x + dx[z];
                                int newY = point.y + dy[z];
                                if(newX < 0 || newX >= N) continue;
                                if(newY < 0 || newY >= M) continue;
                                if(cabbagePatch[newX][newY] == 1) {
                                    stack.add(new Point(newX, newY));
                                }
                            }
                        }
                        count++;
                    }
                }
            }
            System.out.println(count);
        } // test
    } // main

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
