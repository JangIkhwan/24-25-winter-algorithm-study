
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        for(int k = 0 ; k<K;k++){
            String[] input = br.readLine().split(" ");
            int V= Integer.parseInt(input[0]);
            int E= Integer.parseInt(input[1]);

            ArrayList<Integer>[] adList = new ArrayList[V+1];

            for(int i = 0; i <=V ; i++){
                adList[i] = new ArrayList<>();
            }

            for(int i = 0 ; i <E ; i++){
                String[] edge = br.readLine().split(" ");
                int edge1= Integer.parseInt(edge[0]);
                int edge2= Integer.parseInt(edge[1]);
                adList[edge1].add(edge2);
                adList[edge2].add(edge1);
            }
            //여기까지가 인접리스트 생성

            int[] check = new int[V + 1]; // 그룹 정보 저장 (-1, 1)
            boolean isBipartite = true;


            for (int i = 1; i <= V; i++) {
                if (check[i] == 0) { // 방문하지 않은 노드에 대해 BFS 수행
                    if (!bfs(i, adList, check)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            if(isBipartite){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }



        }


    }
    private static boolean bfs(int start, List<Integer>[] adList, int[] check) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        check[start] = 1; // 시작 노드를 그R룹 1로 설정

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : adList[now]) {
                if (check[next] == 0) { // 방문하지 않은 경우
                    check[next] = -check[now]; // 반대 그룹 설정
                    queue.add(next);
                } else if (check[next] == check[now]) { // 같은 그룹이면 이분 그래프 아님
                    return false;
                }
            }
        }
        return true;
    }
}
