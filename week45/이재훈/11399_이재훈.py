N = int(input())
Pi = list(map(int, input().split()))

srt = sorted(Pi)

total = 0
for i in range(N):
  total += sum(srt[:i+1])
print(total)