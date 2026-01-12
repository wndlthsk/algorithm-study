N = int(input())

cycle = 0
cur = N
while True:
  if cur == N and cycle > 0:
    break
  
  left = cur % 10
  right = (cur // 10 + cur % 10) % 10
  cur = left * 10 + right
  cycle += 1
print(cycle)
