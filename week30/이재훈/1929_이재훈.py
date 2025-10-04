def isPrime(x):
  if x == 1 or x <= 0:
    return False
  if x == 2:
    return True
  if x % 2 == 0:
    return False
  for i in range(3, int(x ** 0.5) + 1):
    if x % i == 0:
      return False
  return True

M, N = map(int, input().split())

for x in range(M, N + 1):
  if isPrime(x):
    print(x)