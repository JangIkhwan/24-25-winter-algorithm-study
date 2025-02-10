package week01;

/*
 * 핵심 알고리즘: 백트래킹
 * 입출력을 좀 더 빠르게 개선한 코드
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P14888_2 {

    static int opCount;
    static int globalMin = 1000000000;
    static int globalMax = -1000000000;
    static boolean[] isUsed;
    static ArrayList<Integer> arr;
    static ArrayList<Integer> ops;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n 입력
        int n = Integer.parseInt(st.nextToken());
        opCount = n-1;
        isUsed = new boolean[opCount];
        int[] seq = new int[opCount];
        // 수 입력
        st = new StringTokenizer(br.readLine());
        arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        // 연산자 개수 입력
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> opSet = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            opSet.add(Integer.parseInt(st.nextToken()));
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
