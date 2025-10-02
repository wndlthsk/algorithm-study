N, B = input().split()

res = 0
power = 0
for x in reversed(N):
  if x.isdigit():
    ten = int(x)
  else:
    ten = ord(x) - ord('A') + 10
  res += ten * (int(B) ** power)
  power += 1
print(res)