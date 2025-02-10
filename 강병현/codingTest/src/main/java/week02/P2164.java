package week02;

/*
* BOJ2164 - 카드2
* 주제 - Queue
* DEQUE(덱)를 이용 (앞뒤로 넣을 수 있는 Queue)
*
* 풀이 과정
*   처음에 입력 값들을 Deque에 넣는다.
*   제일 처음에 있는 것이 카드에선 맨 위에 해당하므로 Deque의 첫번째 원소를 제거한다.
*       그리고 다시 첫번째 원소를 꺼내서 Deque의 맨 뒤에 넣는다.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2164 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();

        // 1부터 N 넣기
        for(int i = 1; i <= N; i++){
            dq.add(i);
        }

        while(dq.size() != 1){
            dq.removeFirst();
            Integer second = dq.removeFirst();
            dq.add(second);
        }
        System.out.println(dq.getFirst());
    }

}
