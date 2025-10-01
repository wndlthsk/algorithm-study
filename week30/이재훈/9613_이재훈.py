import math
T = int(input())

for _ in range(T):
  line = list(map(int, input().split()))
  n, l = line[0], sorted(line[1:])

  res = 0
  for i in range(n):
    for j in range(i + 1, n):
      res += math.gcd(l[i], l[j])
  print(res)