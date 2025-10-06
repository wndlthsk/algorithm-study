N = int(input())

res = 1
for i in range(N, 0, -1):
  res *= i
print(res)