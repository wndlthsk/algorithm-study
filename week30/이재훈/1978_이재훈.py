import math
N = int(input())
l = sorted(map(int, input().split()))

def isPrime(x):
  if x == 1 or x <= 0:
    return False
  if x == 2:
    return True
  if x % 2 == 0:
    return False
  
  for i in range(3, int(math.sqrt(x)) + 1, 2):
    if x % i == 0:
      return False
  return True

cnt = 0
for x in l:
  if isPrime(x):
    cnt += 1
print(cnt)