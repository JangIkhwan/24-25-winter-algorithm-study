package week01;

/*
 *  BOJ1018 - 체스판 다시 칠하기
 *  핵심 알고리즘: 브루트 포스
 *
 *  입력
 *      첫째줄: 8 <= N,M <= 50 (자연수)
 *      둘째줄: N개의 줄에 보드의 각 행의 상태가 주어진다. (B: 검은색, W: 흰색)
 *  출력
 *      다시 칠해야 하는 정사각형 개수 최솟값
 *
 *  해결과정
 *      1. 기준 선정 - 처음 시작이 B인가 W인가 2가지 경우의 수를 정했습니다.
 *                   처음엔 체스판에서 열 기준과, 계속 검사하면서 바꿔갈 행 기준을 둡니다.
 *      2. 체크 - init을 W로 줬다면 처음이 B로 시작하는가로 시작됩니다.
 *              왜냐면 저는 체크할 때, 같게 나오는 것을 에러로 처리할 것이기 때문이죠
 *              같지 않으면 통과, 같다면 error를 증가시킵니다.
 *      3. 체인지 - 한 행 안에서 1번 검사를 마쳤다면 현재 열 기준을 바꿔야합니다. (B -> W, W -> B )
 *                 다음 행으로 넘어갈 때에는 이전 행 기준을 사용해서 기존 것과 다른 것으로 바꿉니다. (B -> W, W -> B )
 *      4. 체스판 추출 - 처음 (0,0)을 처음으로 했다면 (0,1), (0,2),.. 이런 식으로 처음 기준을 이동시켜 8x8 판을 검사하는 것을 반복합니다.
 *
 *  문제
 *      문제 안 읽고 처음이 B와 W인 경우를 안 봤다가 시간 낭비
 *
 * */
import java.util.Scanner;

public class P1018 {

    public static void main(String[] args) {

        // 행 열 수 입력
        int row, col; // 8~50
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        // 칠해진 체스판 입력
        String[] board = new String[50];
        for(int i = 0; i < row; i++) {
            board[i] = sc.nextLine();
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
