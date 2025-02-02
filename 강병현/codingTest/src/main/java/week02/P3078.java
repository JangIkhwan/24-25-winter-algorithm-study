package week02;

/*
*   BOJ3078 - 좋은 친구
*   주제 - 큐
*
*   풀이 과정
*       1. 이름 길이 수를 저장하는 배열을 선언한다.
*           여기서 이름 제한이 짧아서 이름 길이를 인덱스로해서 개수를 세었다.
*       2. 처음 K개 만큼 이름 길이들을 queue에 넣는다.
*       3. 그 이후로는 큐에서 제일 늦게 넣은 원소를 꺼내고, 새 값(이름 길이)을 넣는다.
*       4. 각 이름 길이에 해당하는 인덱스에 값를 증가시킨다. 그러면서 범위마다 쌍의 개수 값을 증가시킨다.
*       5. 마지막으로 큐에서 제거하면서 범위 안 쌍들을 구해서 쌍의 개수 값을 증가시킨다.
* */

import java.io.*;
import java.util.*;

public class P3078 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 이름 입력
        long[] nameLengths = new long[21];
        int value;
        long goodFriend = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < K; i++) {
            value = new StringTokenizer(br.readLine()).nextToken().length();
            nameLengths[value]++;
            queue.add(value);
        }

        for(int i = K; i < N; i++){
            value = new StringTokenizer(br.readLine()).nextToken().length();
            nameLengths[value]++;
            queue.add(value);

            Integer poll = queue.poll();
            goodFriend += --nameLengths[poll];
        }

        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            goodFriend += --nameLengths[poll];
        }



        System.out.println(goodFriend);

    }

}
