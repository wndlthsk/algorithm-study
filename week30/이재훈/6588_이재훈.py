import sys
MAX = 1_000_000

# 에라토스테네스의 체
is_prime = [True] * (MAX + 1)
is_prime[0] = is_prime[1] = False

for i in range(2, int(MAX ** 0.5) + 1):
  if is_prime[i]:
    for j in range(i * i, MAX + 1, i):
      is_prime[j] = False

input = sys.stdin.readline
while True:
  N = int(input())
  if N == 0:
    break
  
  found = False
  for a in range(3, N, 2):
    if is_prime[a] and is_prime[N - a]:
      print(f"{N} = {a} + {N - a}")
      found = True
      break
  
  if not found:
    print("Goldbach's conjecture is wrong.")
