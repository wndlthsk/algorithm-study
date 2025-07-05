import sys

middle = sys.stdin.readline().rstrip()

operator = {
    '+' : 1,
    '-' : 1,
    '*' : 2,
    '/' : 2
}

stack = []
result = []
for x in middle:
    if x in operator:
        while stack and stack[-1] != '(' and operator[stack[-1]] >= operator[x]:
            result.append(stack.pop())
        stack.append(x)
    elif x == '(':
        stack.append(x)
    elif x == ')':
        while stack and stack[-1] != '(':
            result.append(stack.pop())
        stack.pop() # '(' 꺼내기
    else:
        result.append(x)

# print(stack)
# print(result)

while stack:
    result.append(stack.pop())
print(''.join(result))