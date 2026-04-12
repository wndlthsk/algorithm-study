N = int(input())
if N == 0:
  print(0)
  exit()

res = []
while N != 0:
  digit = N % -2
  N //= -2
  
  if digit < 0:
    digit += 2
    N += 1
  
  res.append(str(digit))

print(''.join(reversed(res)))