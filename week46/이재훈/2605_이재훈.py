N = int(input())
numbers = list(map(int, input().split()))

line = []
for i in range(N):
  move = numbers[i]
  line.insert(len(line) - move, i + 1)
print(*line)