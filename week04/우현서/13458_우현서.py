import sys

n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))
b, c = map(int, sys.stdin.readline().split())

result = len(a)
for i in range(len(a)):
    a[i] -= b
    if a[i] > 0:
        x, y = divmod(a[i], c)
        if y != 0:
            result += x + 1
        else:
            result += x

print(result)