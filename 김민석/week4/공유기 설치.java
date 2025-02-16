import java.io.*;
import java.util.*;

public class Main {

    private static int[] home;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input =br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        home = new int[N];
        int max = 0;
        int min = 1000000000;

        for(int i = 0 ; i<N;i++){
            int h =Integer.parseInt(br.readLine());
            max = Math.max(max,h);
            min = Math.min(min,h);
            home[i] = h;
        }

        Arrays.sort(home);

        int answer =0;

        int start = 0;
        int end = max;

        while(start<end){
            int mid = (start+end) /2;

            if(start>=mid){
                int an = getCount(end);
                if(an>=C){
                    answer=Math.max(answer,end);

                }else{
                    answer=Math.max(answer,mid);
                }
                break;
            }

            int count = getCount(mid);

            if(count>=C){
                answer=Math.max(answer,mid);
                start=mid;
            }else{
                end=mid;
            }


        }


        System.out.println(answer);
    }

    private static int getCount(int mid) {
        int count = 1;

        int s = home[0];

        for(int i=1;i<home.length;i++){
            if((home[i]-s)>=mid){
                count++;
                s=home[i];
            }
        }


        return count;
    }
}
