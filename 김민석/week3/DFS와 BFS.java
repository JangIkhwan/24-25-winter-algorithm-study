import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] visited;
    private static ArrayList<Integer>[] adList ;
    private static ArrayDeque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args)throws IOException{
        try{

        }catch(Exception e){
            System.out.println(e);
        }
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int T = Integer.parseInt(input[2]);

        adList =new ArrayList[N+1];

        for(int i = 0 ; i<=N;i++){
            adList[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            String[] edge = br.readLine().split(" ");
            adList[Integer.parseInt(edge[0])].add(Integer.parseInt(edge[1]));
            adList[Integer.parseInt(edge[1])].add(Integer.parseInt(edge[0]));
        }

        for(int i = 0 ; i<=N;i++){
           Collections.sort(adList[i]);
        }

        visited =new boolean[N+1];
        StringBuilder dfsSb =  new StringBuilder();
        dfs(T,dfsSb);
        System.out.println(dfsSb.toString().trim());

        Arrays.fill(visited,false);
        StringBuilder bfsSb =  new StringBuilder();
        queue.add(T);
        bfs(bfsSb);
        System.out.println(bfsSb.toString().trim());
    }

    private static void dfs(int now,StringBuilder sb){
        visited[now]= true;
        sb.append(now);
        sb.append(" ");
        for(int next : adList[now]){
            if(visited[next]) continue;
            dfs(next,sb);
        }
    }

    private static void bfs(StringBuilder sb){
        while(!queue.isEmpty()){
            int now = queue.poll();
            if(visited[now]) continue;
            visited[now] = true;
            sb.append(now);
            sb.append(" ");

            for(int next: adList[now]){
                queue.add(next);
            }
        }

    }

}
