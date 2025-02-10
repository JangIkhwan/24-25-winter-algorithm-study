import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line =br.readLine())!=null){
            int n = Integer.parseInt(line);
            int powN= (int)Math.pow(3,n);
            StringBuilder sb =new StringBuilder();
            for(int i = 0 ; i <powN ;i++){
                sb.append("-");
            }
            try{
                findSolution(0,powN-1,sb);

            }catch(Exception e){
                System.out.println(e);

            }

            System.out.println(sb);
        }

    }

    private static void findSolution(int start, int end,StringBuilder sb){
//        System.out.println("start : "+start+", end : "+ end);
        if(start==end){ //재귀 종료 조건 (1개일 경우임)
            return;
        }
        //한 개면 종료
        int gap = (end-start+1)/3;
        String space = " ".repeat(gap);
        int middle1 = start +gap;
        int middle2 = end -gap;
        sb.replace(middle1,middle2+1,space);

        findSolution(start,middle1-1,sb);
        findSolution(middle2+1,end,sb);
    }
}
