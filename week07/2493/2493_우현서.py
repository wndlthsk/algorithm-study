import sys

n = int(sys.stdin.readline())
heights = list(map(int, sys.stdin.readline().split()))
# print(heights)

result = [0] * n
stack = []

for i in range(n-1, -1, -1):
    while stack and heights[i] >= heights[stack[-1]]:
        # print("stack", stack, i, "i")
        result[stack[-1]] = i+1
        stack.pop()
    stack.append(i)
    # print("result", result)

print(*result)