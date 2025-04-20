import sys

a, p = map(int, sys.stdin.readline().split())
d = [a]
i = 0
while True:
    next = 0
    for num in str(d[i]):
        next += int(num) ** p
    if next in d:
        break
    d.append(next)
    i += 1

print(d.index(next))