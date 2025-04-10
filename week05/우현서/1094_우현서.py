import sys

x = int(sys.stdin.readline())
sticks = [64]
while sum(sticks) > x:
    minimum = sticks.pop()
    half = minimum // 2

    if sum(sticks) + half >= x:
        sticks.append(half)
    else:
        sticks.append(half)
        sticks.append(half)
print(len(sticks))