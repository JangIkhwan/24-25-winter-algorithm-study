import java.io.*;
import java.util.*;

public class Main {

    private static int answer = 0;
    private static int[] w;
    private static int k;
    private static int n;
    private static boolean[] selected;


    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map =new HashMap<>();

        String[] NK = br.readLine().split(" ");
        n = Integer.parseInt(NK[0]);    //N일
        k = Integer.parseInt(NK[1]);    //K만큼 감소
        String[] weight = br.readLine().split(" ");
        w = Arrays.stream(weight).mapToInt(Integer::parseInt).toArray();  //각 운동당 얻는 근육량

        selected = new boolean[n];

        backTracking(500);

        System.out.println(answer);
    }

    private static boolean isFinished(boolean[] selected){
        for(int i = 0 ; i<selected.length;i++){
            if(!selected[i]) return false;
        }
        return true;
    }


    private static void backTracking(int muscle){
        if(isFinished(selected)){
            answer++;
            return;
        }

        for(int i= 0 ;i<n;i++){
            if(selected[i]){
                continue;
            }
            if(muscle-k+w[i]>=500){
                selected[i]=true;
                backTracking(muscle-k+w[i]);
                selected[i]=false;
            }
        }
    }

}
