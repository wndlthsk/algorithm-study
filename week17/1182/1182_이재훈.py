N, S = map(int, input().split())
seq = list(map(int, input().split()))

def dfs(index, total):
  if index == N:
    return 1 if total == S else 0
  return dfs(index + 1, total + seq[index]) + dfs(index + 1, total)

cnt = dfs(0, 0)

if S == 0: 
  cnt -= 1
print(cnt)