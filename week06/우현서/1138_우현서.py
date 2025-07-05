import sys

n = int(sys.stdin.readline())
height = list(map(int, sys.stdin.readline().strip().split()))

result = [n]
for i in range(n-2, -1, -1):
    if height[i] >= len(result):
        result.append(i+1)
    else:
        result.insert(height[i], i+1)

print(*result)