package week01;

/*
 * BOJ14888 - 연산자 끼워넣기
 * 핵심 알고리즘: 백트래킹
 *
 * 입력
 *      첫째 줄
 *          N: 수 개수
 *      둘째 줄
 *          A1~An
 *      셋째 줄
 *          합이 N-1개인 4개의 정수 (덧셈, 뺄셈, 곱셈, 나눗셈) 개수
 * 출력
 *      각 줄에 최솟값, 최댓값 출력
 * 수 범위
 *      처음부터 끝 과정까지 -10억~10억
 * 해결과정
 *      연산자들을 각각 자연수에 대응시켜서 1차원배열에 저장시켰다. 예) +: 0, -: 1 등등 (저장 예시: 0,0,0,1,2,2,3)
 *      수는 N개고 연산자는 N-1로 고정이기 때문에 결국 연산자를 어떻게 배치시키냐의 문제가 된다.
 *      따라서 백트래킹을 통해서 연산자들의 모든 배치들을 구하고, 그에 따라 순차적 계산을 통해 최솟값, 최댓값을 구한다.
 * 문제
 *      연산자가 N-1개로 고정된 것인줄 몰랐다.
 *      수 범위를 10억이 아니라 1000만으로 했다가 계속 틀렸었다.
 * */

import java.util.ArrayList;
import java.util.Scanner;

public class P14888 {

    static int opCount;
    static int globalMin = 1000000000;
    static int globalMax = -1000000000;
    static boolean[] isUsed;
    static ArrayList<Integer> arr;
    static ArrayList<Integer> ops;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // n 입력
        int n = sc.nextInt();
        opCount = n-1;
        isUsed = new boolean[opCount];
        int[] seq = new int[opCount];
        // 수 입력
        arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arr.add(sc.nextInt());
        }
        // 연산자 개수 입력
        ArrayList<Integer> opSet = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            opSet.add(sc.nextInt());
        }

        ops = new ArrayList<>();
        for(int i = 0; i < opSet.size(); i++){
            for(int j = 0; j < opSet.get(i); j++){
                ops.add(i);
            }
        }

        // 각 연산 수행
        solution(0, seq);
        System.out.println(globalMax);
        System.out.println(globalMin);
    }

    private static void solution(int stage, int[] seq) {
        int total = arr.get(0);
        if(stage == opCount){

            for(int i = 0; i < opCount; i++){
                switch(seq[i]){
                    case 0:
                        total += arr.get(i+1);
                        break;
                    case 1:
                        total -= arr.get(i+1);
                        break;
                    case 2:
                        total *= arr.get(i+1);
                        break;
                    case 3:
                        total /= arr.get(i+1);
                        break;
                }
            }

            if(total < globalMin)
                globalMin = total;
            if(total > globalMax)
                globalMax = total;

            return;
        }

        // 재귀적으로 연산자들을 배치 시켜준다.
        for(int i = 0; i < opCount; i++) {

            if(!isUsed[i]){ // 사용 중이지 않은 곳을 찾기
                seq[stage] = ops.get(i);
                isUsed[i] = true;
                solution(stage + 1, seq);
                isUsed[i] = false;
            }
        }
    }

}
