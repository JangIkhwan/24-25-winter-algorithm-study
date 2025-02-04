import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] answer = new int[n];
        ArrayDeque<Integer> stack =new ArrayDeque<>();
        A:for(int i = n-1  ; i>=0; i--){
            while(!stack.isEmpty()){
                if(stack.peek()>numbers[i]){
                    answer[i]=stack.peek();
                    stack.push(numbers[i]);
                    continue A;
                }else{
                    stack.pop();
                }
            }
            stack.push(numbers[i]);
            answer[i] =-1;
        }

        StringBuilder sb =new StringBuilder();
        for(int i = 0 ; i<n;i++){
            sb.append(answer[i]);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
