N, K = map(int, input().split())

stk = list(range(1, N + 1))
res = []
start = 0
while stk:
  start = (start + K - 1) % (N - len(res))
  res.append(stk.pop(start))

print(f"<{', '.join(map(str, res))}>")