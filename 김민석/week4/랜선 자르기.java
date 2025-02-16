// long타입으로 바꾸는 것을 유의할 것!
// 처음에 2^31 -1 로 제한을 주어서 int로 써도 된다는 말인줄 알았지만
// mid = (left + right)/2 이 부분에서 overflow가 발생한다.


import java.util.*;
import java.io.*;

public class Main {

    private static long N;
    private static long K;

    private static long[] Lan;

    private static long answer;


    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        K = Long.parseLong(input[0]);
        N = Long.parseLong(input[1]);
        Lan = new long[(int)K];

        long max_k=0;
        for(int i = 0 ; i<Lan.length; i++){
            Lan[i] = Long.parseLong(br.readLine());
            max_k = Math.max(max_k,Lan[i]);
        }

        binarySearch(0,max_k);
        System.out.println(answer);

    }

    private static void binarySearch(long start, long end){
        long mid = (start+end)/2;
        if(start>=mid){
            long getEnd = getLanCount(end);
            if(getEnd>=N){
                answer =  end;
            }else{
                answer =  start;
            }
        }else{
            long lanCount = getLanCount(mid);
            if(lanCount>=N){    //랜의 갯수가 N보다 많을 경우(정답일 가능성있는 경우)
                binarySearch(mid,end);
            }else{
                binarySearch(start,mid-1);
            }
        }
    }

    private static long getLanCount(long lan){
        long lanCount=0;
        for(int i=0; i<Lan.length;i++){
            lanCount+= Lan[i]/lan;
        }
        return lanCount;
    }
}

