package week02;


/*
*   BOJ7795 - 먹을 것인가 먹힐 것인가
*   주제 - 뭐죠?
*
*   풀이과정
*       각 테스트 케이스를 입력 받을 때, A와 B를 정렬 시킨 후
*       A의 크기가 B보다 큰 쌍이 몇 개인지 구한다.
*       이때 효율을 위해 A는 제일 큰 것부터 B는 작은 것부터 비교하게 했다.
*/
import java.io.*;
import java.util.*;

public class P7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int[] answer = new int[T];
        int ANum,BNum;
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            ANum = Integer.parseInt(st.nextToken());
            BNum = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] As = new int[ANum];
            for(int j = 0; j < ANum; j++){
                As[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int[] Bs = new int[BNum];
            for(int j = 0; j < BNum; j++){
                Bs[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(As);
            Arrays.sort(Bs);

            int count = 0;
            for(int j = As.length-1; j >= 0; j--){
                for(int k = 0; k < Bs.length; k++){
                    if(As[j] > Bs[k]) {
                        count++;
                        continue;
                    }
                    break;
                }
            }
            answer[i] = count;
        }

        for(int i = 0; i < T; i++)
            System.out.println(answer[i]);
    }
}
