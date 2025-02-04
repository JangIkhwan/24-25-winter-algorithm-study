import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        int[] order = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack =new ArrayDeque<>();
        ArrayDeque<Integer> queue =new ArrayDeque<>();
        for(int o : order){
            queue.add(o);
        }
        int num =1;
        while(!queue.isEmpty()){
            int now =queue.poll();
            if(now==num){
                num++;
                continue;
            }
            while(!stack.isEmpty() && stack.peek()==num){
                stack.pop();
                num++;
            }
            stack.push(now);
        }
        while(!stack.isEmpty()){
            if(stack.peek()!=num){
                System.out.println("Sad");
                return;
            }else{
                stack.pop();
                num++;
            }
        }
        System.out.println("Nice");
    }
}
