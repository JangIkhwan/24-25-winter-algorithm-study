package week03;
// 방문 가능 번호가 여러 점일 경우 작은 것부터 먼저 방문, 더이상 방문 할게 없으면 좋료

/*
* BOJ1260 - DFS와 BFS
* 주제 - DFS, BFS
*
* 풀이과정
*   저는 이번 문제는 인접 행렬을 통해서 풀었습니다.
*   DFS는 인접 행렬에서 방문하지 않은 곳을 발견할 때 스택에 원소를 넣고,
*   원소를 꺼내고 주위를 살피며 다시 방문하지 않은 곳을 찾습니다.
*   BFS는 인접 행렬 안의 한 행에서 방문하지 않은 곳을 발견할 때마다 큐애 원소를 넣고,
*   원소를 꺼내며 주위를 살펴 다시 방문하지 않은 곳을 찾습니다.
*   결국 DFS와 BFS는 스택을 사용하느냐 큐를 사용하느냐의 차이입니다.
*
*   그리고 DFS는 방문할 수 있는 정점이 여러 개일 때, 작은 번호부터 방문하게 하기 위해
*   뒤에서부터 원소를 넣었습니다.
*
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class P1260 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점
        int M = Integer.parseInt(st.nextToken()); // 간선
        int V = Integer.parseInt(st.nextToken()); // 시작 정점

        // 그래프 입력
        int[][] graph = new int[N+1][N+1];
        int x, y;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        // DFS
        boolean[] isVisited = new boolean[N+1];
        isVisited[V] = true;
        StringBuilder answer1 = new StringBuilder();
        answer1.append(V).append(' ');
        Stack<Integer> stack = new Stack<>();
        stack.add(V);
        while(!stack.isEmpty()){
            int present = stack.pop();
            if(!isVisited[present]){
                isVisited[present] = true;
                answer1.append(present).append(' ');
            }

            for(int i = N; i >= 1; i--){
                if(graph[present][i] == 1 && !isVisited[i]) {
                    stack.add(i);
                }
            }
        }
        System.out.println(answer1);

        // BFS
        isVisited = new boolean[N+1];
        isVisited[V] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        StringBuilder answer2 = new StringBuilder();
        answer2.append(V).append(' ');
        while(!queue.isEmpty()){
            int present = queue.poll();
            for(int i = 1; i <= N; i++){
                if(graph[present][i] == 1 && !isVisited[i]){
                    queue.add(i);
                    isVisited[i] = true;
                    answer2.append(i).append(' ');
                }
            }
        }
        System.out.println(answer2);
    }
}
