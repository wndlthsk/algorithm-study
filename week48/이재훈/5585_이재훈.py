n = int(input())
change = 1000 - n

coins = [500, 100, 50, 10, 5, 1]
cnt = 0

for coin in coins:
  cnt += change // coin
  change %= coin
print(cnt)