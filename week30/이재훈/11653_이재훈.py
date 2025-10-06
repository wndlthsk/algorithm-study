N = int(input())
if N == 1:
  exit()

res = []
div = 2
while True:
  if N <= 1:
    break
  if N % div == 0:
    N = N // div
    res.append(div)
  else:
    div += 1
print(*res, sep='\n')