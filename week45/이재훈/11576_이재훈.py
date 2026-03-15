A, B = map(int, input().split())
m = int(input())
baseA = list(map(int, input().split()))

total = 0
for digit in baseA:
  total = total * A + digit

res = []
while total > 0:
  digit = total % B
  total //= B
  res.append(digit)
print(*res[::-1])