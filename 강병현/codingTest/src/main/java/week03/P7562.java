package week03;

/*
* BOJ7562 - 나이트의 이동
* 주제 - BFS
*
* 풀이과정
*   나이트의 최소 이동으로 원하는 지점까지 가기 위해서는 BFS로 하는게 맞다고 생각했습니다.
*   DFS로 하면 처음에 너무 오래 걸릴 경우 언제 끝날지 모르기 때문입니다.
*   Point 클래스에 seq 변수를 둬서 이동 횟수를 체크하며 이동 횟수의 최솟값을 구했습니다.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7562 {

    static int min = 999;
    static int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
    static int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

    static Point end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int i = 0; i < T; i++){
            min = 999;
            // 체스판 한 변의 길이
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());

            // 나이트가 현재 있는 칸
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            Point std = new Point(x1, y1, 0);

            // 나이트가 이동하려고 하는 칸
            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            end = new Point(x2, y2, 0);

            if(std.x == end.x && std.y == end.y){
                System.out.println(0);
                continue;
            }

            // 나이트가 최소 몇 번만에 이동할 수 있는가(BFS)
            boolean[][] board = new boolean[length][length];
            Queue<Point> queue = new LinkedList<>();
            queue.add(std);
            board[std.x][std.y] = true;
            boolean find = false;
            while(!queue.isEmpty()){
                Point start = queue.poll();
                for(int j = 0; j < 8; j++) {
                    int newX = start.x + dx[j];
                    int newY = start.y + dy[j];
                    if(newX < 0 || newX >= length) continue;
                    if(newY < 0 || newY >= length) continue;

                    if(!board[newX][newY]) {
//                        System.out.println("newX: " + newX + "newY: " + newY);
                        board[newX][newY] = true;
                        queue.add(new Point(newX, newY, start.seq+1));


                        if(newX == end.x && newY == end.y){
                            min = start.seq + 1;
                            find = true;
                            break;
                        }
                    }

                }
                if(find)
                    break;
            }

            System.out.println(min);
        }

    }

    static class Point{
        int x;
        int y;
        int seq;

        public Point(int x, int y, int seq){
            this.x = x;
            this.y = y;
            this.seq = seq;
        }
    }
}
