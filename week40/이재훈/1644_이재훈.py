import sys
input = sys.stdin.readline

N = int(input())

# 1️⃣ 에라토스테네스의 체
is_prime = [True] * (N + 1)
is_prime[0] = is_prime[1] = False

for i in range(2, int(N ** 0.5) + 1):
  if is_prime[i]:
    for j in range(i * i, N + 1, i):
      is_prime[j] = False

primes = [i for i in range(2, N + 1) if is_prime[i]]

# 2️⃣ 투 포인터
left, right = 0, 0
current_sum = 0
count = 0

while True:
  if current_sum >= N:
    if current_sum == N:
      count += 1
    current_sum -= primes[left]
    left += 1
  else:
    if right == len(primes):
      break
    current_sum += primes[right]
    right += 1
print(count)