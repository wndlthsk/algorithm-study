import sys
sys.setrecursionlimit(10**6)

N = int(input())
Ai = list(map(int, input().split()))
op_cnt = list(map(int, input().split()))

d = {
  0: lambda x, y: x + y,
  1: lambda x, y: x - y,
  2: lambda x, y: x * y,
  3: lambda x, y: -(-x // y) if x < 0 else x // y,
}

max_val = float('-inf')
min_val = float('inf')

def dfs(idx, cur, op):
  global max_val, min_val
  
  if idx == N - 1:
    max_val = max(max_val, cur)
    min_val = min(min_val, cur)
    return
  
  for cmd in range(4):
    if op[cmd] > 0:
      nxt_cur = d[cmd](cur, Ai[idx + 1])
      op[cmd] -= 1
      dfs(idx + 1, nxt_cur, op)
      op[cmd] += 1

dfs(0, Ai[0], op_cnt[:])

print(max_val)
print(min_val)