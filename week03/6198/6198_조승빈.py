n = int(input())
arr =[]
stack = []
answer = 0
for _ in range(n):
    arr.append(int(input()))
for a in arr:
    
    while stack and stack[-1] <=a:
        stack.pop()
    answer+=len(stack)
    stack.append(a)
print(answer)