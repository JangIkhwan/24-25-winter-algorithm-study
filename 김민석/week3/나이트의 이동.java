import java.io.*;
import java.util.*;

public class Main {
    private static final int[] dx = {1,2,2,1,-1,-2,-2,-1};
    private static final int[] dy = {2,1,-1,-2,-2,-1,1,2};
    private static ArrayDeque<Point> queue;

    private static int[] end;
    private static boolean[][] visited;
    private static int I;

    private static class Point{
        int x;
        int y;
        int depth;


        public Point(int x, int y,int depth){
            this.x=x;
            this.y=y;
            this.depth = depth;
        }
    }


    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i<T ; i++){
            I = Integer.parseInt(br.readLine());
            int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            end = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            visited = new boolean[I][I];

            queue= new ArrayDeque<>();
            queue.add(new Point(start[0],start[1],0));
            visited[start[1]][start[0]] = true;
            bfs();



        }

    }

    private static void bfs(){
        while(!queue.isEmpty()){
            Point now = queue.poll();

            if(now.x==end[0]&&now.y==end[1]){
                System.out.println(now.depth);
                return;
            }

            for(int i =0;i<8;i++){
                int new_x = now.x + dx[i];
                int new_y = now.y + dy[i];

                if(new_x<0 || new_y <0 || new_x>=I || new_y>=I){ //범위 밖을 벗어날 경우
                    continue;
                }

                if(visited[new_y][new_x]){
                    continue;
                }

                visited[new_y][new_x] = true;
                queue.add(new Point(new_x,new_y,now.depth+1));
            }
        }

    }
}
