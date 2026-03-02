cards = list(range(1, 21))

for _ in range(10):
  s, e = map(int, input().split())
  cards[s-1:e] = reversed(cards[s-1:e])
print(*cards)