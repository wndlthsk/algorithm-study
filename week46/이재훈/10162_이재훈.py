T = int(input())

buttons = [300, 60, 10]
counts = [0, 0, 0]

for i in range(3):
  counts[i] = T // buttons[i]
  T %= buttons[i]

if T != 0:
  print(-1)
else:
  print(*counts)