T = int(input())
for _ in range(T):
  line = list(map(int, input().split()))
  print(sorted(line, reverse=True)[2])