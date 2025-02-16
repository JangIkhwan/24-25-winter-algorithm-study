

import java.io.*;
import java.util.*;

public class Main {
    private static int M;
    private static int N;

    private static final int[] dx = {0,0,-1,1};
    private static final int[] dy = {-1,1,0,0};



    private static int[][] tomatos;
    private static ArrayDeque<Point> queue;


    private static class Point{
        int x;
        int y;
        int depth;
        public Point(int x, int y,int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        tomatos = new int[N][M];
        for (int i = 0; i < N; i++) {
            tomatos[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        queue = new ArrayDeque<>();
        for(int i =0 ;i <N;i++){
            for(int j=0;j<M;j++){
                if(tomatos[i][j]==1){
                    queue.add(new Point(j,i,0));
                }
            }
        }

        if(queue.isEmpty()){
            System.out.println("-1");
            return;
        }

        int answer = bfs();

        if(!isFull()&&queue.isEmpty()){
            System.out.println("-1");
        }else{
            System.out.println(answer);
        }


    }

    private static int bfs(){
        int maxDepth=0;
        while(!queue.isEmpty()){
            Point now= queue.poll();
//            System.out.println("x :" + now.x + ",y : "+ now.y + ",depth : " + now.depth);
            maxDepth = Math.max(maxDepth, now.depth); // 최종 depth 값 저장

            for(int i =0 ; i<4;i++){
                int new_x = now.x+dx[i];
                int new_y = now.y+dy[i];

                if(new_x<0 || new_y<0 || new_x>=M || new_y>=N){
                    continue;
                }
                if(tomatos[new_y][new_x]==-1 || tomatos[new_y][new_x]==1){
                    continue;
                }
                tomatos[new_y][new_x]= 1;

                queue.add(new Point(new_x,new_y,now.depth+1));
            }
        }
        return maxDepth;
    }

    private static boolean isFull(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(tomatos[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }



}
