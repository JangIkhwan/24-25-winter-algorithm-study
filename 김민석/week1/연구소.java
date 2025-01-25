package 백준;
import java.util.*;
import java.io.*;

public class Solution14502 {
    private static int[] dn = {0,0,-1,1};
    private static int[] dm = {-1,1,0,0};
    private static int N;
    private static int M;
    private static int[][] map;
    private static int max;
    private static ArrayList<Node> virus=new ArrayList<>();
    private static ArrayList<Node> safeZone=new ArrayList<>();


    private static class Node{
        int n,m;
        public Node(int n, int m){
            this.n = n;
            this.m = m;
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        //입력값 받기
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];

        for(int i=0;i<N;i++){
            String[] in = br.readLine().split(" ");
            map[i] = Arrays.stream(in).mapToInt(Integer::parseInt).toArray();
        }

        max = 0;  //최대값을 그냥 맵의 가로 세로 곱해서 넣어줌.


        findVirus();
        buildWall(0,0);
        System.out.println(max);

    }

    private static void findVirus(){
        for(int i=0; i<N ;i++){
            for(int j=0 ; j<M ; j++){
                if(map[i][j]==2) virus.add(new Node(i,j));;
                if(map[i][j]==0) safeZone.add(new Node(i,j));
            }
        }
    }

    private static void buildWall(int count,int start){
        if(count==3){
            max=Math.max(virusSpread(),max);
            return;
        }
        for (int i = start; i < safeZone.size(); i++) {
            Node node = safeZone.get(i);
            map[node.n][node.m] = 1; // 벽 세우기
            buildWall(count + 1, i + 1); // 다음 벽 세우기
            map[node.n][node.m] = 0; // 되돌리기
        }
    }



    private static int virusSpread(){  //bfs를 써서 바이러스를 퍼뜨려줌
        boolean[][] visited = new boolean[N][M];
        int safe = safeZone.size()-3;

        ArrayDeque<Node> queue= new ArrayDeque<>(virus);
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nn = now.n + dn[i];
                int mm = now.m + dm[i];
                if (nn < 0 || mm < 0 || nn >= N || mm >= M) {   //가장자리 범위를 넘을 경우
                    continue;
                }
                if (map[nn][mm] == 2 || map[nn][mm] == 1 || visited[nn][mm]) { //벽이거나 이미 감염됐을 경우 pass
                    continue;
                }

                safe--;
                visited[nn][mm]=true;
                queue.add(new Node(nn, mm));
            }
        }
        return safe;
    }



}

