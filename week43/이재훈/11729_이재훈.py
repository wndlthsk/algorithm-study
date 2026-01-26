def hanoi(n, start, to, via, res):
  if n == 1:
    res.append((start, to))
    return
  hanoi(n - 1, start, via, to, res)
  res.append((start, to))
  hanoi(n - 1, via, to, start, res)

N = int(input())
res = []
hanoi(N, 1, 3, 2, res)

print(len(res))
for s, t in res:
  print(s, t)