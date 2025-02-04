import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i =1; i<=N;i++){
            queue.add(i);
        }

        if(N==1){
            System.out.println(N);
            return;
        }

        while(!queue.isEmpty()){
            queue.poll();
            if(queue.size()==1){    //queue에 하나밖에 안남았으르 경우
                System.out.println(queue.poll());
                break;
            }
            queue.add(queue.poll());
        }
    }
}
