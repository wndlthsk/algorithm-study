from collections import deque
n,m = map(int,input().split(" "))
arr = list(map(int,input().split(" ")))
q = deque()

answer = 0
q.append((arr[0],1))
q.append((0,1))
while q:
    x,idx= q.popleft()
    if idx == n:
        if x == m:
            answer+=1
        continue
    q.append((x,idx+1))
    q.append((x+arr[idx],idx+1))
if m == 0:
    answer-=1 
print(answer)