N = int(input())
players = [list(map(int, input().split())) for _ in range(N)]

best = -1
winner = 0
for i in range(N):
  nums = players[i]
  max_val = 0
  for a in range(5):
    for b in range(a+1, 5):
      for c in range(b+1, 5):
        s = (nums[a] + nums[b] + nums[c]) % 10
        max_val = max(max_val, s)
  
  if max_val >= best:
    best = max_val
    winner = i + 1
print(winner)