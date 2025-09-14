N = int(input())
Ai = list(map(int, input().split()))

# 1. LIS (왼쪽에서 오른쪽으로)
lis = [1] * N
for i in range(N):
  for j in range(i):
    if Ai[j] < Ai[i]:
      lis[i] = max(lis[i], lis[j] + 1)

# 2. LDS (오른쪽에서 왼쪽으로)
lds = [1] * N
for i in range(N - 1, -1, -1):
  for j in range(N - 1, i, -1):
    if Ai[j] < Ai[i]:
      lds[i] = max(lds[i], lds[j] + 1)

# 3. LIS + LDS - 1 (중복 피크 제거)
result = 0
for i in range(N):
  result = max(result, lis[i] + lds[i] - 1)
print(result)