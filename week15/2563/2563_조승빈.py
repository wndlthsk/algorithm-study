n = int(input())
arr = [[0] * 100 for _ in range(100)]
for _ in range(n):
    x, y = map(int, input().split())
    for i in range(x, x + 10):
        for j in range(y, y + 10):
            arr[i][j] = 1  
print(sum(row.count(1) for row in arr))