def get_in_perfect(n):
  res = []
  for x in range(1, n):
    if n % x == 0:
      res.append(x)
  return res

while True:
  n = int(input())
  if n == -1:
    break
  
  res = get_in_perfect(n)
  total = sum(res)
  if total == n:
    print(f"{n} = {' + '.join(map(str, res))}")
  else:
    print(f"{n} is NOT perfect.")