N = int(input())
Ai = list(map(int, input().split()))
op_cnt = list(map(int, input().split()))

operator = [
  lambda x, y: x + y,
  lambda x, y: x - y,
  lambda x, y: x * y,
  lambda x, y: x // y if x >= 0 else -(abs(x) // y),
]

max_val = float('-inf')
min_val = float('inf')
def dfs(idx, acc, cnt):
  global max_val, min_val
  if idx == N - 1:
    max_val = max(max_val, acc)
    min_val = min(min_val, acc)
    return
  
  for i, op in enumerate(operator):
    if cnt[i] > 0:
      cnt[i] -= 1
      dfs(idx + 1, op(acc, Ai[idx + 1]), cnt)
      cnt[i] += 1
dfs(0, Ai[0], op_cnt[:])
print(max_val)
print(min_val)
