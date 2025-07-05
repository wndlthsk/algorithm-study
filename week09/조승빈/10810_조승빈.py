n, m = map(int, input().split())
baskets = [0] * n

for _ in range(m):
    i, j, k = map(int, input().split())
    for idx in range(i-1, j):
        baskets[idx] = k

print(*baskets)
