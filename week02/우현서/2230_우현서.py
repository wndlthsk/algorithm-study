import sys
n, m = map(int, sys.stdin.readline().split())
a = []
for _ in range(n):
    a.append(int(sys.stdin.readline()))
a.sort()

min_diff = float("inf")
left = 0
right = 0

while left <= right < n:
    if a[right] - a[left] == m:
        min_diff = min(min_diff, a[right] - a[left])
        break
    elif a[right] - a[left] > m:
        min_diff = min(min_diff, a[right] - a[left])
        left += 1
    else:
        right += 1
print(min_diff)