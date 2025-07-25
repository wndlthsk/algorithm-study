N = int(input())
seq = list(map(int, input().split()))
target = seq[-1]

# dp[idx][cur] = idx번째까지 계산해서 cur값을 만들 수 있는 경우의 수
dp = [[-1] * 21 for _ in range(N)]

def dfs(idx, cur):
  if cur < 0 or cur > 20:
    return 0

  if idx == N - 1:
    return 1 if cur == target else 0

  if dp[idx][cur] != -1:
    return dp[idx][cur]

  res = 0
  res += dfs(idx + 1, cur + seq[idx])
  res += dfs(idx + 1, cur - seq[idx])
  dp[idx][cur] = res
  return res
print(dfs(1, seq[0]))