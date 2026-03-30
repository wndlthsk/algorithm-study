import sys
input = sys.stdin.readline

N = int(input())
nums = [1, 5, 10, 50]

res = set()
def dfs(idx, cnt, total):
  if cnt == N:
    res.add(total)
    return

  for i in range(idx, 4):
    dfs(i, cnt+1, total + nums[i])

dfs(0, 0, 0)
print(len(res))