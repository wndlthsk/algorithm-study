K = int(input())

res = []
for _ in range(K):
  num = int(input())
  if num == 0:
    res.pop()
  else:
    res.append(num)
print(sum(res))