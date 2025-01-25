package week01;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/*
* BOJ14502 - 연구소
* 핵심 알고리즘: 백트래킹(재귀), 그래프 순회(DFS or BFS)
*
* 입력
*   첫째 줄 - 지도의 세로 크기 N, 가로 크기 M (3 <= N,M <= 8)
*   둘째 줄부터 N개의 줄에 지도의 모양(0: 빈칸(3개 이상), 1: 벽, 2: 바이러스(2 < 2의 개수 < 10))
* 출력
*   안전 영역의 최대 크기
* 해결과정
*   1. 벽 설치: 재귀를 통해서 백트래킹을 써서 연구실에 벽을 설치했습니다.
*           탈출 조건 - 벽 3개 설치
*   2. 바이러스 전염
*           처음 입력 받을 때 바이러스 위치를 저장시켰습니다.
*           Stack을 이용해서 DFS를 구현해 2(바이러스)를 전염시켰습니다.
*   3. 안전 영역 크기 구하기
*           처음 입력 받을 때 안전 영역 개수를 구합니다. (벽 3개 설치도 포함)
*           바이러스를 전염시킬 때마다 전염된 바이러스 개수를 구하고
*           처음 안전 영역 개수에서 바이러스 개수를 뺍니다.
*   문제
*       스택에 있는 것을 한 번에 꺼낼 때에는 문제가 없었는데 하나씩 꺼내면 문제가 생기는 이유는 자세히 모르겠다.
*       코드 깔끔하게 못 짜겠습니다. - 재귀말고 다른 것으로 구현해야하나
*       처음에 안 풀렸던 이유가 배열을 깊은 복사를 하지않고 얕은 복사를 해서 각 케이스에 영향을 주게 하였기 때문이었다.
* */
public class P14502 {

    static int N;
    static int M;

    static int maxSafe = 0;
    static int basicSafe;
    static int basicVirus;
    static ArrayList<Point> virusPos;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1~n 중 m개 고른 수열
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 연구소
        int value;
        int[][] board = new int[N][M];
        virusPos = new ArrayList<>();
        basicVirus = 0;
        basicSafe = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                value = Integer.parseInt(st.nextToken());
                board[i][j] = value;
                if(value == 0)
                    basicSafe++;
                if(value == 2) {
                    virusPos.add(new Point(i,j));
                    basicVirus++;
                }
            }
        }

        basicSafe -= 3;
        // 벽 설치 - 난 재귀로 함
        installWall(1, board);
        System.out.println(maxSafe);
    }

    private static void spreadingVirus(int[][] boards) {
        Stack<Point> stack = new Stack<>();
        int[][] board = new int[boards.length][];
        for (int i = 0; i < boards.length; i++) {
            board[i] = boards[i].clone(); // 각 행 배열을 복사
        }

        int localVirus = 0;
        for(Point virus : virusPos)
            stack.push(virus);
        // 위 코드 아래 코드 합치면 답이 이상하게 나올까
        while(!stack.isEmpty()){
            Point pos = stack.pop();
            if(pos.x-1 >= 0 && board[pos.x-1][pos.y] == 0){
                stack.push(new Point(pos.x-1, pos.y));
                board[pos.x-1][pos.y] = 2;
                localVirus++;
            }
            if(pos.x+1 < N && board[pos.x+1][pos.y] == 0){
                stack.push(new Point(pos.x+1, pos.y));
                board[pos.x+1][pos.y] = 2;
                localVirus++;
            }
            if(pos.y-1 >= 0 && board[pos.x][pos.y-1] == 0){
                stack.push(new Point(pos.x, pos.y-1));
                board[pos.x][pos.y-1] = 2;
                localVirus++;
            }
            if(pos.y+1 < M && board[pos.x][pos.y+1] == 0){
                stack.push(new Point(pos.x, pos.y+1));
                board[pos.x][pos.y+1] = 2;
                localVirus++;
            }
        }
        if(maxSafe < basicSafe - localVirus) {
            maxSafe = basicSafe - localVirus;
        }
    }

    private static void installWall(int stage, int[][] board) {
        if(stage > 3){
            spreadingVirus(board);
            return;
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] == 0) {
                    board[i][j] = 1;
                    installWall(stage+1, board);
                    board[i][j] = 0;
                }
            }
        }
    }

}
