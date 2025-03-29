def max_candies(board):
    n = len(board)
    max_count = 1
    
    # 행 검사
    for i in range(n):
        count = 1
        for j in range(1, n):
            if board[i][j] == board[i][j-1]:
                count += 1
                max_count = max(max_count, count)
            else:
                count = 1

    # 열 검사
    for j in range(n):
        count = 1
        for i in range(1, n):
            if board[i][j] == board[i-1][j]:
                count += 1
                max_count = max(max_count, count)
            else:
                count = 1

    return max_count

N = int(input())

arr = []
for _ in range(N):
    arr .append(list(input()))

answer = 0 
for x in range(N):
    
    for  y in range(N):
        if y+1 <N and arr[x][y] != arr[x][y+1]:
            tmp  =   arr[x][y]
            arr[x][y] = arr[x][y+1]
            arr[x][y+1] = tmp
            answer= max(answer,max_candies(arr))
            tmp  =   arr[x][y]
            arr[x][y] = arr[x][y+1]
            arr[x][y+1] = tmp

        if x+1 <N and arr[x][y] != arr[x+1][y]:
            tmp  =   arr[x][y]
            arr[x][y] = arr[x+1][y]
            arr[x+1][y] = tmp
            answer= max(answer,max_candies(arr))
            tmp  =   arr[x][y]
            arr[x][y] = arr[x+1][y]
            arr[x+1][y] = tmp

        
print(answer)
