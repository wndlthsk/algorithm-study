N, B = input().split()

length = len(N)
res = 0
for i in range(length):
  ch = N[i]
  if '0' <= ch <= '9':
    value = int(ch)
  else:
    value = ord(ch) - ord('A') + 10
  power = length - 1 - i
  res += value * (int(B) ** power)
print(res)