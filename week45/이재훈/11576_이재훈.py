toA, toB = map(int, input().split())
m = int(input())
nums_from_A = list(map(int, input().split()))

digit = 0
for idx, v in enumerate(nums_from_A[::-1]):
  digit += v * (toA ** idx)

res = []
if digit == 0:
  res.append(0)
else:
  while digit > 0:
    res.append(digit % toB)
    digit //= toB
print(' '.join(map(str, res[::-1])))