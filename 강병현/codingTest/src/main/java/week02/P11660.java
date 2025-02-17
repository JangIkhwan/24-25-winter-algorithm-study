package week02;

/*
* BOJ11660 - 구간 합 구하기 5
* 주제 - 구간 합
* 풀이 과정
*   원소를 그냥 넣지 않고 행마다 누적값을 넣습니다.
*   그리고 각 행마다 구간의 끝과 처음 전을 빼서 해당 구간의 합을 구하고 합칩니다.
*   그래서 (x1,y1)부터 (x2,y2)의 합을 구했습니다.
* */
import java.io.*;
import java.util.*;

public class P11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] chart1 = new int[N][N];
        int sum = 0;
        for(int i = 0; i < N; i++){
            sum = 0;
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int i1 = Integer.parseInt(st.nextToken());
                chart1[i][j] = (sum + i1);
                sum += i1;
            }
        }

        int x1, x2;
        int y1, y2;
        int total = 0;
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < M; i++){
            total = 0;
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken())-1;
            y1 = Integer.parseInt(st.nextToken())-1;
            x2 = Integer.parseInt(st.nextToken())-1;
            y2 = Integer.parseInt(st.nextToken())-1;


            for(int j = x1; j <= x2; j++){
                int a = y1 == 0 ? 0 : y1-1;
                if(y1 == 0)
                    total += chart1[j][y2];
                else
                    total += chart1[j][y2] - chart1[j][a];
            }

            answer.append(total).append('\n');
        }
        System.out.println(answer);

    }
}
