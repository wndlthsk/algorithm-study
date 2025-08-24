N = int(input())
Ai = list(map(int, input().split()))
op_cnt = list(map(int, input().split()))

op = {
  0: lambda x, y : x + y,
  1: lambda x, y : x - y,
  2: lambda x, y : x * y,
  3: lambda x, y : x // y if x > 0 else -(abs(x) // y),
}

def dfs(idx, cur):
  if idx == N - 1:
    return cur, cur
  
  max_val, min_val = float('-inf'), float('inf')
  
  for i in range(4):
    if op_cnt[i] > 0:
      op_cnt[i] -= 1
      new_cur = op[i](cur, Ai[idx + 1])
      child_max, child_min = dfs(idx + 1, new_cur)
      max_val = max(max_val, child_max)
      min_val = min(min_val, child_min)
      op_cnt[i] += 1
  
  return max_val, min_val
max_val, min_val = dfs(0, Ai[0])
print(max_val)
print(min_val)