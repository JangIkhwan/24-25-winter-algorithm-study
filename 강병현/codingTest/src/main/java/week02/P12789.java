package week02;


/*
* BOJ12789 - 도키도키 간식드리미
* 주제 - 스택, 큐
*
* 풀이 과정
*   입력을 queue에 담는다. (줄 서는 곳)
*   처음 queue부터 차례가 왔는지 확인하고 아니면 stack에서 차례를 찾는다.
*   queue나 stack에 하나라도 차례가 있다면 해당 위치에서 제거를 한다.
*   둘 다 차례가 없다면 queue에 있는 사람을 다른 줄에 넣는다.(한명씩만 설 수 있는 공간)
*   queue에서 다 제거하였다면 그 후엔 stack에서 모두 pop하려고 한다.
*   최종적으로 들어온 수만큼 count(seq)가 증가하였다면 nice 아니면 sad를 출력하게 하였다.
*
*   여기서 seq는 다음에 와야할 순서, number는 queue에서 꺼낸 순서 값이다.
* */

import java.io.*;
import java.util.*;

public class P12789 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Integer> line = new LinkedList<>();
        for(int i = 0; i < N; i++){
            line.offer(Integer.parseInt(st.nextToken()));
        }
        Stack<Integer> line2 = new Stack<>();

        int seq = 1;
        while(!line.isEmpty()){
            // 1. queue 확인
            int number = line.peek();;
            if(number == seq){
                seq++;
                line.poll();
                continue;
            }
            // 2. stack 확인
            int number2;
            if(!line2.isEmpty()) {
                number2 = line2.peek();
                if(number2 == seq){
                    line2.pop();
                    seq++;
                    continue;
                }
            }

            // 3. stack에 queue 원소 넣기
            line2.push(number);
            line.poll();
        }

        // 스택 비우기
        while(!line2.isEmpty()) {
            if(line2.pop() == seq)
                seq++;
        }

        if(N == seq-1)
            System.out.println("Nice");
        else
            System.out.println("Sad");
    }
}
