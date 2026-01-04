N = int(input())

for res in range(N):
  total = res + sum(map(int, list(str(res))))
  if total == N:
    print(res)
    exit()

print(0)