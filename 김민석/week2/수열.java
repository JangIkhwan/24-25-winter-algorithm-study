import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input  = br.readLine().split(" ");
        int N= Integer.parseInt(input[0]);
        int K= Integer.parseInt(input[1]);

        String[] in = br.readLine().split(" ");
        int[] temp = Arrays.stream(in).mapToInt(Integer::parseInt).toArray();



        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int sum=0;

        for(int i =0;i<K;i++){
            queue.add(temp[i]);
            sum+=temp[i];
        }
        int max = sum;

        for(int i=K;i<N;i++){
            int first = queue.poll();
            sum-=first;
            sum+=temp[i];
            queue.add(temp[i]);
            max = Math.max(sum,max);
        }


        System.out.println(max);


    }
}
