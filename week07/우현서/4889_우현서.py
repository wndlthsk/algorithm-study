import sys

rank = 1
while True:
    line = sys.stdin.readline().strip()
    if '-' in line:
        break

    stack = []
    for ch in line:
        if ch == '{':
            stack.append(ch)
        else:  # ch == '}'
            if stack and stack[-1] == '{':
                stack.pop()
            else:
                stack.append(ch)

    left = stack.count('{')
    right = len(stack) - left
    count = (left + 1) // 2 + (right + 1) // 2

    print(f"{rank}. {count}")
    rank += 1
