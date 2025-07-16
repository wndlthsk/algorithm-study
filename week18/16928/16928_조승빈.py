from collections import deque
l,s = map(int,input().split(" "))
arr = {}
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
        if pos+i >100:
            break
        if (pos+i) in arr :
            vis[arr[pos+i]] = 1
            q.append((arr[pos+i],cnt+1))
            continue
        if vis[pos+i] == 0:
            q.append((pos+i,cnt+1))
            vis[pos+i] = 1


