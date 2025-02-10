import java.io.*;
import java.util.*;

public class Main {
    private static final int[] dx = {0,0,-1,1};
    private static final int[] dy = {-1,1,0,0};

    private static int M;
    private static int N;
    private static int[][] board;
    private static int answer;

    private static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }


    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        try{
            for(int t =0;t<T;t++){
                String[] input = br.readLine().split(" ");
                M = Integer.parseInt(input[0]);
                N = Integer.parseInt(input[1]);
                int K = Integer.parseInt(input[2]);
                answer =0;


                board = new int[N][M];

                for(int i=0;i<K;i++){
                    String[] in = br.readLine().split(" ");
                    int m =  Integer.parseInt(in[0]); //가로
                    int n =  Integer.parseInt(in[1]); //세로
                    board[n][m] = 1;
                }

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (board[i][j] == 1) {
                            bfs(j, i); // x, y 순서로 전달
                        }
                    }
                }

                System.out.println(answer);
            }

        }catch(Exception e){
            System.out.println(e);
        }




    }

    private static void bfs(int xx,int yy){
        ArrayDeque<Point> queue; queue = new ArrayDeque<>();
        queue.add(new Point(xx,yy));
        answer++;

        while(!queue.isEmpty()){
            Point now = queue.poll();
            board[now.y][now.x] =0;
            for(int i = 0;i<4;i++){
                int new_x = now.x +dx[i];
                int new_y = now.y +dy[i];

                if(new_x<0 || new_y<0 || new_x >= M || new_y >= N) continue;

                if(board[new_y][new_x]==0) continue;

                board[new_y][new_x] =0;

                queue.add(new Point(new_x,new_y));

            }

        }
    }


}

