package week01;

import java.util.Scanner;

/*
*   BOJ4339 - 칸토어 집합
*   핵심 알고리즘: 재귀
*
*   입력: EOF가 있을 때까지 각 줄에 정수 N을 입력 받는다. (0 <= N <= 12)
*   출력: 각 N에 대한 칸토어 집합의 근사
*
*   해결 과정
*       처음에 N이 0,1,.. 하나씩 증가시키면서 코딩을 했다.
*       그리고 각 반복적으로 나뉘어지는 문자 "-"의 모음에
*       재귀를 적용시켜 계속 3분할 하였다.
*   문제1
*       System.out.print으로 계속 출력시켰는데 시간 초과가 발생하였다.
*       그래서 StringBuilder를 통해서 결과를 모아서 한번에 출력하는 방향으로 하였다.
* */
public class P4779 {

    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {

        // 입력: N
        // "-" 개수: 3^N
        // N이 1이 될 때까지 각 구역 분할
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()) {
            long a = sc.nextInt();
            long b = (long) Math.pow(3, a);
            recurCantor(b);
            System.out.println(answer);
            answer.setLength(0);
        }

        sc.close();
    }

    private static void recurCantor(long b) {
        if(b == 1) {
            answer.append("-");
            return;
        }
        long c = b/3;

        recurCantor(c);
        for(int i = 0; i < c; i++)
            answer.append(" ");
        recurCantor(c);
    }
}
