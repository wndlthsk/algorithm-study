nums = [int(input()) for _ in range(7)]
odds = [x for x in nums if x % 2 == 1]

if not odds:
  print(-1)
else:
  print(sum(odds))
  print(min(odds))