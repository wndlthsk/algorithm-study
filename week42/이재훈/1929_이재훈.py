M, N = map(int, input().split())

def is_prime(x):
  if x <= 1:
    return False
  if x == 2:
    return True
  if x % 2 == 0:
    return False
  
  for i in range(3, int(x ** 0.5) + 1, 2):
    if x % i == 0:
      return False
  return True

for x in range(M, N + 1):
  if is_prime(x):
    print(x)