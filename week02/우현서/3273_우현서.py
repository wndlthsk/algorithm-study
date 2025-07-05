import sys

n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))
x = int(sys.stdin.readline())
a.sort()
left = 0
right = n-1
count = 0

while left < right:
    # print(a[left]+a[right])
    if a[left] + a[right] == x:
        count += 1
        left += 1
        right -= 1
    elif a[left] + a[right] < x:
        left += 1
    else:
        right -= 1

print(count)

