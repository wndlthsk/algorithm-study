N = int(input())
Wi = list(map(int, input().split()))

res = 0
def dfs(n, weights, energy):
  global res
  
  if n == 2:
    res = max(res, energy)
    return
  
  for i in range(1, n - 1):
    e = weights[i - 1] * weights[i + 1]
    p = weights.pop(i)
    dfs(n - 1, weights, energy + e)
    weights.insert(i, p)

dfs(N, Wi[:], 0)
print(res)