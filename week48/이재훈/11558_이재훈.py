import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
  N = int(input())
  arr = [0] + [int(input()) for _ in range(N)]
  
  visited = [False] * (N + 1)
  cur = 1
  cnt = 0
  
  while True:
    if cur == N:
      print(cnt)
      break
    
    if visited[cur]:
      print(0)
      break
    
    visited[cur] = True
    cur = arr[cur]
    cnt += 1