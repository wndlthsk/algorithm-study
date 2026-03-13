n, d = map(int, input().split())

cnt = 0
for num in range(1, n + 1):
  while num > 0:
    if num % 10 == d:
      cnt += 1
    num = num // 10
print(cnt)