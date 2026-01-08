N, M, K = map(int, input().split())

team = min(N // 2, M)
remain = (N + M) - (3 * team)

if remain < K:
  lack = K - remain
  team -= (lack + 2) // 3
print(team)