package week01;

/*
 * BOJ18429 - 근손실
 * 핵심 알고리즘: 백트래킹
 *
 * 입력
 *      첫째 줄: 자연수 N(일) (1~8), 감소량 K (1~50)
 *      둘째 줄: 운동 키트의 중량 증가량 A (1~50)
 *
 * 해결과정
 *      재귀 탈출 조건은 '키트를 적용시킨 수'로 했습니다.
 *      boolean 배열(isUsed)로 해당 키트를 사용했는지 안 했는지 나타내었습니다.
 *          그래서 1 2 3 이런식만 되는게 아니라 3 1 2, 3 2 1 이런 식도 가능하게 했습니다.
 *      처음에 500 + K를 한 이유는 함수로 넘어가고 1일차에서 중량을 500을 만들기 위함입니다.(하루가 지나야 K만큼 감소한다는 것을 반영)
 *
 *
 * 문제
 *      처음에 키트를 사용하고 다시 원 상태로 안 돌려서 계속 중량이 늘어나는 문제가 발생했었습니다.
 *      사용한 뒤에는 꼭 정리를 해야한다는 교훈을 얻었습니다.
 * */

import java.util.Scanner;

public class P18429 {


    static int count = 0;
    static int N;
    static int K;
    static int[] up;
    static boolean[] isUsed;

    public static void main(String[] args) {

        // 입력
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 일
        K = sc.nextInt(); // 감소

        up = new int[N];
        for(int i = 0; i < N; i++)
            up[i] = sc.nextInt();

        isUsed = new boolean[N];

        int weight = 500 + K;
        applyKit(1,weight);

        System.out.println(count);
    }

    private static void applyKit(int applyCount, int weight) {

        if(applyCount > N){
            count++;
            return;
        }

        weight -= K;
        if(weight < 500)
            return;

        for(int i = 0; i < N; i++){

            if(!isUsed[i]){
                weight += up[i];
                isUsed[i] = true;
                applyKit(applyCount+1, weight);
                isUsed[i] = false;
                weight -= up[i];
            }
        }
    }
}
