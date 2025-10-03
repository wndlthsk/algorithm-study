def divmod_neg2(n):
  q, r = divmod(n, -2)
  if r < 0:   # 나머지를 양수로 강제
    q += 1
    r += 2
  return q, r

N = int(input())

if N == 0:
  print(0)
else:
  digits = []
  while N != 0:
    N, r = divmod_neg2(N)
    digits.append(str(r))
  print("".join(reversed(digits)))
