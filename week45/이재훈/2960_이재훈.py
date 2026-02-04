N, K = map(int, input().split())

prime = [True] * (N + 1)
prime[0] = False
prime[1] = False

res = []
for i in range(2, N + 1):
  if prime[i]:
    for j in range(i, N + 1, i):
      if prime[j]:
        prime[j] = False
        res.append(j)
print(res[K - 1])