N = input()
length = len(N)

ans = "NO"
for i in range(1, length):
  left = N[:i]
  right = N[i:]
  
  l_mul = 1
  for x in left:
    l_mul *= int(x)
  
  r_mul = 1
  for x in right:
    r_mul *= int(x)
  
  if l_mul == r_mul:
    ans = "YES"
    break
print(ans)