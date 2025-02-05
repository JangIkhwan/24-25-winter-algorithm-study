#제일 왼쪽,위에 해당하는 경우가 흰색,검은색인지에 따라 잘 만들어진 체스판을 2차원 배열로 선언한다.

white_arr=['WBWBWBWB',
           'BWBWBWBW',
           'WBWBWBWB',
           'BWBWBWBW',
           'WBWBWBWB',
           'BWBWBWBW',
           'WBWBWBWB',
           'BWBWBWBW',]

black_arr=['BWBWBWBW',
           'WBWBWBWB',
           'BWBWBWBW',
           'WBWBWBWB',
           'BWBWBWBW',
           'WBWBWBWB',
           'BWBWBWBW',
           'WBWBWBWB',]

m,n = map(int,input().split())

input_arr = [input() for _ in range(m)]
diff_arr = []
#빈 배열에 위의 두 경우에 따라 입력받은 체스판에서 8X8 로 잘라
#두 가지 경우에 따라 비교하며 다시 칠해야 하는 정사각형의 개수(잘 만들어진 체스판과 다른 곳의 개수)를 저장한다.

for i in range(m-8+1):
    for j in range(n-8+1):
        white_count = 0
        black_count = 0
        for a in range(8):
            for b in range(8):
                if input_arr[i+a][j+b]!=white_arr[a][b]:
                    white_count+=1
                if input_arr[i+a][j+b]!=black_arr[a][b]:
                    black_count+=1
        diff_arr.append(min(black_count,white_count))

#저장한 배열에서 가장 적은 개수를 출력한다.
print(min(diff_arr))