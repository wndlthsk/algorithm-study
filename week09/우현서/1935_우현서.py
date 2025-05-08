import sys

n = int(sys.stdin.readline())
post = sys.stdin.readline()
numbers = []
for _ in range(n):
    numbers.append(int(sys.stdin.readline()))

stack = []
for x in post:
    if x.isalpha():
        stack.append(numbers[ord(x) - ord('A')])
    else:
        if len(stack) >= 2:
            # print(x)
            right = stack.pop()
            left = stack.pop()
            if x == '+':
                stack.append(left + right)
            elif x == '-':
                stack.append(left - right)
            elif x == '*':
                stack.append(left * right)
            elif x == '/':
                stack.append(left / right)
            # print("s", stack)

print(f"{stack.pop():.2f}")