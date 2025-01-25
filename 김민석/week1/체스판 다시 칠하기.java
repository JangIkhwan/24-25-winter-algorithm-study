import java.util.*;
import java.io.*;

public class Main{
    private static char[][] board;
    private static final char[] white ={'W','B','W','B','W','B','W','B'};
    private static final char[] black ={'B','W','B','W','B','W','B','W'};

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] aryLen = br.readLine().split(" ");

        //행, 열 저장
        int row =  Integer.parseInt(aryLen[0]);
        int col =  Integer.parseInt(aryLen[1]);

        //보드 배열을 담아둘 배열
        board = new char[row][col];
        for(int i = 0 ; i< row ; i++){
            board[i]=br.readLine().toCharArray();
        }
        int answer =64;

        for(int i = 0; i<= row- 8;i++){
            for(int j=0; j<= col-8;j++){
                int temp = countChess(i,j);

                if(answer > temp) answer=temp;
            }
        }



        System.out.println(answer);

    }

    private static int countChess(int row, int col){
        int count =0;
        for(int i=0;i<8;i++){
            for(int j = 0; j<8;j++){
                if(i%2==0){
                    if(board[row+i][col+j]==white[j]) count++;
                }else{
                    if(board[row+i][col+j]==black[j]) count++;
                }
            }
        }
        return Math.min(64-count,count);
    }
}