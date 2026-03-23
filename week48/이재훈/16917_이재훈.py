A, B, C, X, Y = map(int, input().split())

res = float('inf')
for i in range(0, max(X, Y)*2 + 1, 2):
  cost = i * C
  remain_x = max(0, X - i//2)
  remain_y = max(0, Y - i//2)
  cost += remain_x * A + remain_y * B
  res = min(res, cost)
print(res)