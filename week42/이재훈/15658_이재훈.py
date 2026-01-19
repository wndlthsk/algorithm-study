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
def dfs(node, cur, arr):
  global max_val, min_val
  if node == N - 1:
    min_val = min(min_val, cur)
    max_val = max(max_val, cur)
    return
  
  for idx in range(4):
    if op_cnt[idx] > 0:
      val = d[idx](cur, Ai[node + 1])
      arr[idx] -= 1
      dfs(node + 1, val, arr)
      arr[idx] += 1
dfs(0, Ai[0], op_cnt)

print(max_val)
print(min_val)