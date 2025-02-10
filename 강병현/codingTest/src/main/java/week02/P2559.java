package week02;

/*
 *  BOJ2559 - 수열
 *  주제: 구간합
 *
 *  풀이 과정
 *      입력을 받은 후 K 값에 따라 구간합을 구한 다음 최댓값을 구한다.
 *      for문 종료 조건을 N-K까지 해서 인덱스 범위를 넘어서지 않게 했다.
 * */

import java.io.*;
import java.util.*;

public class P2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int[] temperature = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            temperature[i] = Integer.parseInt(st.nextToken());
        }

        int max = -1000000;
        int sum;
        for(int i = 0; i < N-K+1; i++){
            sum = 0;
            for(int j = i; j < i+K; j++){
                sum += temperature[j];
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);

    }

}
