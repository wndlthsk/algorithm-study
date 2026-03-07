import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

# 2D prefix sum 배열
prefix = [[0]*(M+1) for _ in range(N+1)]

for r in range(1, N+1):
  for c in range(1, M+1):
    prefix[r][c] = (
      arr[r-1][c-1]
      + prefix[r-1][c]
      + prefix[r][c-1]
      - prefix[r-1][c-1]
    )

K = int(input())
for _ in range(K):
  i, j, x, y = map(int, input().split())
  
  total = (
    prefix[x][y]
    - prefix[i-1][y]
    - prefix[x][j-1]
    + prefix[i-1][j-1]
  )
  
  print(total)