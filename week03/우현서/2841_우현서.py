import sys
n, p = map(int, sys.stdin.readline().split())

stacks = [[] for _ in range(7)]
count = 0
for _ in range(n):
    x, y = map(int, sys.stdin.readline().split())
    while stacks[x] and stacks[x][-1] > y:
        # print(stacks[x][-1])
        stacks[x].pop()
        count += 1
        # print(y, count)

    if not stacks[x] or stacks[x][-1] != y:
        stacks[x].append(y)
        count += 1
print(count)