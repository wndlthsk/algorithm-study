from collections import deque
F, S, G, U, D = map(int,input().split(" "))
vis = [0] * (F+1)
q = deque()
q.append((S,0))
flag = 1
while q:
    cur,cnt = q.popleft()
    if cur == G:
        print(cnt)
        flag = 0 
        break
    if cur+U <= F and vis[cur+U]==0:
        q.append((cur+U,cnt+1))
        vis[cur+U]=1
    if cur-D >= 1 and vis[cur-D]==0:
        q.append((cur-D,cnt+1))
        vis[cur-D]=1
if flag == 1:
    print("use the stairs")
        
        