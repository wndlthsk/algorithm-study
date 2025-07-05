import sys
from collections import deque

n = int(sys.stdin.readline())
numbers = deque(map(int, sys.stdin.readline().strip().split()))

stack = []
turn = 1

while numbers:
    if numbers[0] == turn:
        numbers.popleft()
        turn += 1
    elif stack and stack[-1] == turn:
        stack.pop()
        turn += 1
    else:
        stack.append(numbers.popleft())


result = True
while stack:
    if stack[-1] == turn:
        stack.pop()
        turn += 1
    else:
        result = False
        break

if result:
    print("Nice")
else:
    print("Sad")