import sys
input = sys.stdin.readline
MOD = 1_000_000_007

def power(a, b):
  if b == 0:
    return 1
  half = power(a, b // 2)
  if b % 2 == 0:
    return half * half % MOD
  else:
    return half * half * a % MOD

N, K = map(int, input().split())

fact = [1] * (N + 1)
for i in range(1, N + 1):
  fact[i] = fact[i - 1] * i % MOD

denom = fact[K] * fact[N - K] % MOD
inv_denom = power(denom, MOD - 2)

print(fact[N] * inv_denom % MOD)
