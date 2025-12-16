T = int(input())

for _ in range(T):
  C = int(input())
  coins = []

  coins.append(C // 25)
  C %= 25

  coins.append(C // 10)
  C %= 10

  coins.append(C // 5)
  C %= 5

  coins.append(C // 1)
  C %= 1

  print(*coins)