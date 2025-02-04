import java.io.*;


public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] input =br.readLine().split(" ");
        int N =Integer.parseInt(input[0]);
        int K =Integer.parseInt(input[1]);

        long answer=0;

        //이름 길이를 저장할 배열 생성(최대 20자니까 20+1으로 생성)
        int[] nameLengthCount = new int[21];

        int[] nameLength = new int[N];
        for(int i =0;i<N;i++){
            nameLength[i]=br.readLine().length();
        }

        for(int i=0;i<K;i++){
            nameLengthCount[nameLength[i]]++;
        }

        for(int i=0;i<N-1;i++){
            if((i+K)<=N-1) nameLengthCount[nameLength[i+K]]++;
            answer+=nameLengthCount[nameLength[i]]-1;
            nameLengthCount[nameLength[i]]--;
        }

        System.out.println(answer);

    }
}
