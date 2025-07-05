N = int(input())
arr = list(map(int, input().split()))

line = []

for height in range(N, 0, -1):  
    position = arr[height - 1]  
    line.insert(position, height)

print(*line)
