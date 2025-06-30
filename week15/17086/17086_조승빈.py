from collections import deque
n,m = map(int,input().split())
vis= []
for x in range(n):
    vis.append(list(map(int,input().split())))

nx=[0,0,-1,1,1,1,-1,-1]
ny=[-1,1,0,0,-1,1,-1,1]
q=deque()
for x in range(n):
    for y in range(m):
        if vis[x][y] ==1:
            q.append([x,y])
while q:
    x,y =q.popleft()
    for idx in range(8):
        px = x+nx[idx]
        py = y+ny[idx]
        if px<0 or py<0 or px>n-1 or py >m-1:
            continue
        if vis[px][py] == 0:
            vis[px][py] = vis[x][y] +1
            q.append([px,py])
answer=0  
for x in range(n):
    for y in range(m):
        answer= max(answer,vis[x][y])
print(answer-1)
            
