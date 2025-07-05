from collections import deque
l,s = map(int,input().split(" "))
arr = [i for i in range(101)]
for _ in range(l+s):
    start,end = map(int,input().split(" "))
    arr[start] = end
vis = [0] * (101)
q = deque()
q.append((1,0))
vis[1]=1
while q:
    pos,cnt = q.popleft()
    if pos == 100:
        print(cnt)
        break
    for i in range(1,7):
        idx  = pos+i
        if  idx>100:
            break
        if vis[arr[idx]] ==0 :
            vis[arr[idx]] = 1
            q.append((arr[idx],cnt+1))

        

