import sys
input = sys.stdin.readline

L = int(input())
N = int(input())

cake = [0] * (L + 1)

max_expect = 0
expect_idx = 0

max_real = 0
real_idx = 0

for i in range(1, N + 1):
  P, K = map(int, input().split())

  if K - P + 1 > max_expect:
    max_expect = K - P + 1
    expect_idx = i

  cnt = 0
  for j in range(P, K + 1):
    if cake[j] == 0:
      cake[j] = i
      cnt += 1

  if cnt > max_real:
    max_real = cnt
    real_idx = i

print(expect_idx)
print(real_idx)