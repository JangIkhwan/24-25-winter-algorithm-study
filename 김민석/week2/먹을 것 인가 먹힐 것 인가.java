import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i =0 ; i<T;i++){
            String[] input = br.readLine().split(" ");
            int nSize = Integer.parseInt(input[0]);
            int MSize = Integer.parseInt(input[1]);

            int[] N = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray(); //5
            int[] M = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();   //3
            int mPointer = 0;
            int nPointer =0;
            int answer =0;
            while(nPointer< nSize && mPointer <MSize){
                if(N[nPointer]>M[mPointer]){
                    answer += nSize - nPointer;
                    mPointer++;

                }else{
                    nPointer++;
                }
            }

            System.out.println(answer);

        }
    }
}
