N = int(input())
Pi = list(map(int, input().split()))

Pi.sort()

total = 0
current = 0

for t in Pi:
  current += t  # 지금 사람까지 기다린 시간
  total += current
print(total)