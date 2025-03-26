import sys
n = int(sys.stdin.readline())
h = []
for _ in range(n):
    h.append(int(sys.stdin.readline()))

count = 0
stack = []
for i in h:
    while stack and i >= stack[-1]:
        stack.pop()
    count += len(stack)
    stack.append(i)

print(count)