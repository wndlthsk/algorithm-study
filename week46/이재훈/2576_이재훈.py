odds = []
for _ in range(7):
  digit = int(input())
  if digit % 2 != 0:
    odds.append(digit)

if odds:
  print(sum(odds))
  print(min(odds))
else:
  print(-1)