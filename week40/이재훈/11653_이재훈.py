N = int(input())

MAX = int(N ** 0.5) + 1

for x in range(2, MAX + 1):
  while N % x == 0:
    print(x)
    N //= x

if N > 1:
  print(N)
