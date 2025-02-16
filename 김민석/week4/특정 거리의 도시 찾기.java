
import java.io.*;
import java.util.*;
public class Main {
    private static int N;
    private static int M;
    private static int K;
    private static int X;

    private static class Node{
        int dest;
        int cost;

        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }


    public static void main(String[] args)throws IOException{


        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N =Integer.parseInt(input[0]);
        M =Integer.parseInt(input[1]);
        K =Integer.parseInt(input[2]);
        X =Integer.parseInt(input[3]);

        ArrayList<Node>[] adList =new ArrayList[N+1];

        for(int i = 1 ;i<=N;i++){
            adList[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            String[] in = br.readLine().split(" ");
            adList[Integer.parseInt(in[0])].add(new Node(Integer.parseInt(in[1]),1));
        }

        boolean[] visited = new boolean[N+1];
        int[] distance = new int[N+1];

        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[X] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1.cost,o2.cost));

        pq.add(new Node(X,0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if (visited[now.dest]) {
                continue;
            }
            visited[now.dest]=true;

            for(Node next: adList[now.dest]){
                if(distance[next.dest] > now.cost + next.cost){
                    distance[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, distance[next.dest]));
                }

            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i =1 ; i < distance.length; i++){
            if(distance[i]==K){
                answer.add(i);
            }
        }

        answer.sort((o1,o2)->Integer.compare(o1,o2));

        if(answer.isEmpty()){
            System.out.println("-1");
        }else{
            for(int i=0;i<answer.size();i++){
                System.out.println(answer.get(i));
            }
        }

    }
}
