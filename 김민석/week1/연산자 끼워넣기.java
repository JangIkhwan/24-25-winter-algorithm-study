import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] numbers;

    private static int[] operator;

    private static int max;
    private static int min;


    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 세 번째 입력: 연산자 개수 (+, -, *, / 순)
        operator = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        max = -1000000000;
        min = 1000000000;

        findSolution(1,numbers[0]);





        System.out.println(max);
        System.out.println(min);
    }

    private static void findSolution(int index,int result){
        if(index==N){
            max = Math.max(result,max);
            min = Math.min(result,min);
            return;
        }
        for(int i=0;i<4;i++){
            if(operator[i]==0) continue;
            operator[i]--;
            findSolution(index+1,operate(result,numbers[index],i));
            operator[i]++;
        }
    }

    private static int operate(int o1, int o2, int op){
        if(op==0) return o1+o2;
        else if(op==1) return o1-o2;
        else if(op==2) return o1*o2;
        else return o1/o2;
    }
}
