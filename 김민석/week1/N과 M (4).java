import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int K;


    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input =br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        back(new ArrayList<>(), 1,0);
    }

    private static void back(ArrayList<Integer> list,int idx,int depth){
        if(depth ==K){
            for(int i =0; i<list.size();i++){
                System.out.print(list.get(i));
                if(i!=list.size()-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
            return;
        }

        for(int i=idx;i<=N; i++){
            ArrayList<Integer> ary = new ArrayList<>(list);
            ary.add(i);
            back(ary,i,depth+1);
        }

    }
}
