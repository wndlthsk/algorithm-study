import sys

for line in sys.stdin:
  n = int(line.rstrip())
  if n == -1:
    break
  
  res = []
  for i in range(1, n // 2 + 1):
    if n % i == 0:
      res.append(i)
  
  total = sum(res)
  if total == n:
    print(f"{n} = {' + '.join(map(str, res))}")
  else:
    print(f"{n} is NOT perfect.")