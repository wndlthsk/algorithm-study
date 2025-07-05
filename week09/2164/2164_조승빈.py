from collections import deque
n = int(input())
arr = deque(i for i in  range(1,n+1))
while n>1 and arr:
    if not arr:
        break
    arr.popleft()
    if not arr:
        break
    tmp = arr.popleft()
    arr.append(tmp)
    n-=1
print(arr[0])
