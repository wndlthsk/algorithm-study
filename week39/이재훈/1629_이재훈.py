def power(a, b, c):
  if b == 1:
    return a % c

  half = power(a, b // 2, c)

  if b % 2 == 0:
    return (half * half) % c
  else:
    return (half * half * a) % c

A, B, C = map(int, input().split())
print(power(A, B, C))