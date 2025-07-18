N = int(input())
Ai = list(map(int, input().split()))
cnt = list(map(int, input().split()))

cal = {
  0: lambda a, b: a + b,
  1: lambda a, b: a - b,
  2: lambda a, b: a * b,
  3: lambda a, b: -(abs(a) // b) if a < 0 else a // b
}

def dfs(idx, result, op_cnt):
  if idx == N:
    return result, result

  local_max = float('-inf')
  local_min = float('inf')

  for op in range(4):
    if op_cnt[op] > 0:
      op_cnt[op] -= 1
      new_result = cal[op](result, Ai[idx])
      max_r, min_r = dfs(idx + 1, new_result, op_cnt)
      local_max = max(local_max, max_r)
      local_min = min(local_min, min_r)
      op_cnt[op] += 1

  return local_max, local_min

max_val, min_val = dfs(1, Ai[0], cnt[:])
print(max_val)
print(min_val)