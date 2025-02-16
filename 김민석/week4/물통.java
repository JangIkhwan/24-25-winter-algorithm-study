
import java.io.*;
import java.util.*;

public class Main {
    private static class Water{
        int a;
        int b;
        int c;

        public Water(int a, int b, int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] input =br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);

        HashSet<Integer> answer = new HashSet<>();

        boolean[][][] visited = new boolean[201][201][201];

        ArrayDeque<Water> queue=  new ArrayDeque<>();

        queue.add(new Water(0,0,C));

        while(!queue.isEmpty()){
            Water water =queue.poll();

            int a =water.a;
            int b =water.b;
            int c =water.c;

            if(a==0){
                answer.add(c);
            }

            if(visited[a][b][c]){
                continue;
            }

            visited[a][b][c]=true;

            //A->B
            if(a+b > B){//넘칠경우는 넘치기 직전까지만
                queue.add(new Water(a-B+b,B,c));
            }else{
                queue.add(new Water(0,a+b,c));
            }
            //A->C
            if(a+c > C){//넘칠경우는 넘치기 직전까지만
                queue.add(new Water(a-C+c,b,C));
            }else{
                queue.add(new Water(0,b,a+c));
            }
            //B->A
            if(b+a > A){//넘칠경우는 넘치기 직전까지만
                queue.add(new Water(A,b-A+a,c));
            }else{
                queue.add(new Water(a+b,0,c));
            }
            //B->C
            if(b+c > C){//넘칠경우는 넘치기 직전까지만
                queue.add(new Water(a,b-C+c,C));
            }else{
                queue.add(new Water(a,0,b+c));
            }
            //C->A
            if(c+a > A){//넘칠경우는 넘치기 직전까지만
                queue.add(new Water(A,b,c-A+a));
            }else{
                queue.add(new Water(c+a,b,0));
            }
            //C->B
            if(c+b > B){//넘칠경우는 넘치기 직전까지만
                queue.add(new Water(a,B,c-B+b));
            }else{
                queue.add(new Water(a,b+c,0));
            }

        }

        StringBuilder sb= new StringBuilder();
        answer.stream().sorted().forEach(a->{
            sb.append(a);
            sb.append(" ");
        });

        System.out.println(sb.toString().trim());


    }
}


//8 9 10
//1 9 0

//1 2 8 9 10

//1 : C->B
//2 : C->A, A->B
//8 : C->A, C->B, A->C
//9 : C->B, C->A, B->C, A->B
//10


