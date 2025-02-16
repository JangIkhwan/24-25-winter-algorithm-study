import java.util.*;
import java.io.*;

public class Main  {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());
        int[] requests = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        HashMap<Integer,Integer> map =new HashMap<>();
        for(int n : cards){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        StringBuilder sb =new StringBuilder();

        for(int r : requests){
            sb.append(map.getOrDefault(r,0));
            sb.append(" ");
        }

        System.out.println(sb.toString().trim());

    }

}
