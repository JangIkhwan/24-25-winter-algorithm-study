package week01;

/*
 * 핵심 알고리즘: 브루트 포스
 * 입출력을 좀 더 빠르게 개선한 코드
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1018_2 {

    public static void main(String[] args) throws IOException {

        // 행 열 수 입력
        int row, col; // 8~50
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        // 칠해진 체스판 입력
        String[] board = new String[50];
        String str = "";
        for(int i = 0; i < row; i++) {
            board[i] = br.readLine();
        }

        // 체스판 크기는 8 X 8
        // 최소 개수 구해야함
        // 오류 검출
        int minError = 100;
        int error;
        int errorInitW;
        int errorInitB;

        for(int xp = 0;  xp + 8 <= row; xp++){
            if(xp + 8 > row)
                break;
            for(int yp = 0; yp + 8 <= col; yp++){
                if(yp + 8 > col)
                    break;
                errorInitW = checkError(board, xp, yp, 'B');
                errorInitB = checkError(board, xp, yp, 'W');
                error = Math.min(errorInitW, errorInitB);
                if(error < minError)
                    minError = error;
            }
        }

        System.out.println(minError);
    }

    private static int checkError(String[] board, int row, int col, char init) {
        int error = 0;
        //char std = board[row].charAt(col);
        char std = init;
        char initStd = std;

        for(int i = row; i < row+8; i++){
            for(int j = col; j < col+8; j++){
                if(board[i].charAt(j) == std){
                    error += 1;
                }
                std = (std == 'W') ? 'B' : 'W';
            }
            //std = (board[i].charAt(col) == 'W') ? 'W' : 'B'; // 상대적 기준
            std = (initStd == 'W') ? 'B' : 'W'; // 절대적 기준
            initStd = (std == 'W') ? 'W' : 'B';
        }
        return error;
    }
}
