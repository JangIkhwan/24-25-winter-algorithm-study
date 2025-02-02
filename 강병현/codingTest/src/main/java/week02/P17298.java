package week02;

import java.io.*;
import java.util.*;

/*
* ( 이건 단조 스택 검색해보고 예제들 보면서 풀었습니다.)
* BOJ17298 - 오큰수
* 주제 - (단조)스택
*
* 풀이과정
*   입력 값들을 배열에 저장합니다.
*   스택에 배열 값을 차례로 넣으면서, 넣는 값이 스택의 top에 있는 값보다 크면
*   스택을 pop하면서 나오는 인덱스를 통해 정답 배열에 접근해 넣는 값들을 넣습니다.
*   마지막엔 스택에 남아있는 값(인덱스)들을 이용해 나머지를 -1로 채웁니다.
*
* 배운점
*   단조스택은 자체로는 유용함이 없지만,
*   단조스택으로 만드는 과정 또는 새 원소가 입력되었을 때,
*   정렬하는 과정에서 얻는 정보들이 유용하다.
*
*   풀 수 있는 문제의 예시 - Find Next Greatest Number
*       단순히 배열을 돌아다니면서 풀면 O(N^2)이 나오지만 단조 스택을 이용하면 O(N)으로 풀 수 있다.
*
* */

public class P17298 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            array.add(Integer.parseInt(st.nextToken()));
        }

        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            Integer i1 = array.get(i);
            while(!stack.isEmpty() && array.get(stack.peek()) < i1){
                answer[stack.pop()] = array.get(i);
            }
            stack.add(i);
        }

        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            sb.append(answer[i]).append(" ");
        System.out.println(sb);
    }
}
