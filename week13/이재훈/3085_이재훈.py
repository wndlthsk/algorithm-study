N = int(input())
arr = [list(input()) for _ in range(N)]

# 최대 연속 길이 계산 함수
def check(board):
  max_cnt = 0
  # 행 검사
  for i in range(N):
    cnt = 1 # 연속된 사탕 개수 (초기값 1)
    for j in range(1, N):
      if board[i][j] == board[i][j - 1]:
        cnt += 1  # 이전 사탕과 같으면 연속이므로 +1
        max_cnt = max(max_cnt, cnt) # 최대값 갱신
      else:
        cnt = 1 # 연속 끊겼으면 다시 1부터 시작
  # 열 검사
  for j in range(N):
    cnt = 1
    for i in range(1, N):
      if board[i][j] == board[i - 1][j]:
        cnt += 1
        max_cnt = max(max_cnt, cnt)
      else:
        cnt = 1
  return max_cnt

# swap 모든 경우 시도. 하나의 i,j 좌표에 대해 좌우, 상하 swap후 큰 값으로 갱신.
res = 0
for i in range(N):
  for j in range(N):
    # 오른쪽 swap
    if j + 1 < N:
      arr[i][j], arr[i][j + 1] = arr[i][j + 1], arr[i][j]
      res = max(res, check(arr))
      arr[i][j], arr[i][j + 1] = arr[i][j + 1], arr[i][j]  # 원상복구

    # 아래쪽 swap
    if i + 1 < N:
      arr[i][j], arr[i + 1][j] = arr[i + 1][j], arr[i][j]
      res = max(res, check(arr))
      arr[i][j], arr[i + 1][j] = arr[i + 1][j], arr[i][j]  # 원상복구
print(res)

# 하나의 i, j에서 큰 값 갱신.
# i, j + 1 : 좌우 swap
# i + 1, j : 상하 swap
# => i, j가 늘어나며, 자동으로 swap 범위가 정리됨.