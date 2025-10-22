T = int(input())
for _ in range(T):
  R, S = input().split()
  R = int(R)
  res = []
  for x in S:
    res.append(x * R)
  print(''.join(res))