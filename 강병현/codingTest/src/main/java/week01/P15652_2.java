package week01;

/*
 * 핵심 알고리즘: 백트래킹
 * 입출력을 좀 더 빠르게 개선한 코드
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15652_2 {

    static int N;
    static int M;
    // 현재 상태
    static int[] states; // 기본값 0
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        states = new int[M];

        dfs(0, 1);
        System.out.print(sb);
    }

    private static void dfs(int stage, int start) {
        if(stage == M){
            for(int state : states) {
                //System.out.print(state + " ");
                sb.append(state).append(" ");
            }
            sb.append("\n");
            //System.out.println();
            return;
        }

        for(int i = start; i <= N; i++){
            states[stage] = i;
            dfs(stage + 1, i);
        }

    }
}
