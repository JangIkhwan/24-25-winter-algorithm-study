package week01;

import java.util.Scanner;

/*
* BOJ15652 - N과 M(4)
* 핵심 알고리즘: 백트래킹
*
* 입력
*   첫째 줄: 자연수 N,M ( 1 <= M <= N <= 8 )
* 출력
*   한 줄마다 조건을 만족하는 수열 출력 (중복되는 수열 출력 X, 각 수열은 공백으로 구분)
*   조건
*       1~N까지 M개 고른 수열
*       같은 수 여러번 골라도 된다.
*       고른 수열은 비내림차순
*
*   해결과정
*       처음에는 재귀로 모든 경우의 수를 배열에 넣었다. (1,2), (1,3),.. (3,1),(3,2)
*       그리고 배열 안에서 원소가 이전 원소보다 큰지 작은지 체크해서 출력하도록 하였다.
*   반성
*       처음에 재귀를 적용시키는 법을 몰라서 테스트하면서 하다보니 이런 비효율적인 풀이가 나왔다.
*       ver2에는 이렇게 안 했습니다. ver2에는 인자로 시작 위치도 넣어서 비내림차순으로 만들었다.
* */
public class P15652 {

    static int N;
    static int M;
    // 현재 상태
    static int[] states; // 기본값 0
    // 방문 처리
    static boolean[] visited; // 기본값 false

    public static void main(String[] args) {

        // 입력
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        states = new int[M];
        visited = new boolean[N+1];

        dfs(0);
    }

    private static void dfs(int stage) {
        if(stage == M){
            for(int i = 0; i < M-1; i++){
                if(states[i] > states[i+1])
                    return;
            }

            for(int state : states) {
                System.out.print(state + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++){
            states[stage] = i;
            dfs(stage + 1);
        }

    }
}
