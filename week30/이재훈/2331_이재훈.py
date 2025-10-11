def plus_each_numbers(number, P):
  res = 0
  for ch in str(number):
    res += int(ch) ** P
  return res

A, P = map(int, input().split())

seen_idx = 0
ans = []
while True:
  if len(ans) == 0:
    ans.append(A)
    continue
  
  A = plus_each_numbers(A, P)
  if A in ans:
    seen_idx = ans.index(A)
    break
  ans.append(A)
ans = ans[:seen_idx]
print(len(ans))