N = int(input())
dist = list(map(int, input().split()))
price = list(map(int, input().split()))

min_price = price[0]
total = 0

for i in range(N - 1):
  min_price = min(min_price, price[i])
  total += min_price * dist[i]

print(total)