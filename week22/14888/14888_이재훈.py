N = int(input())
Ai = list(map(int, input().split()))
op_cnt = list(map(int, input().split()))

cal = {
  0: lambda x, y: x + y,
  1: lambda x, y: x - y,
  2: lambda x, y: x * y,
  3: lambda x, y: x // y if x > 0 else -(abs(x) // y),
}

min_val, max_val = float('inf'), float('-inf')
op_left = op_cnt[:]
def dfs(start, acc):
  global min_val, max_val
  
  if start == N - 1:
    min_val = min(acc, min_val)
    max_val = max(acc, max_val)
    return
  
  for i in range(4):
    if op_left[i] > 0:
      op_left[i] -= 1
      dfs(start + 1, cal[i](acc, Ai[start + 1]), op_left)
      op_left[i] += 1
dfs(0, Ai[0])
print(max_val)
print(min_val)