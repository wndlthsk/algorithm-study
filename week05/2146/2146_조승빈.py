from collections import deque
n = int(input())
arr = []
for _ in range(n):
    arr.append(list(map(int,input().split(" "))))
vis = [[0 for _ in range(n)]for _ in range(n)]
flag = 1
nx = [-1,1,0,0]
ny = [0,0,-1,1]
for ix in range(n):
    for iy in range(n):
        if arr[ix][iy] == 1 and vis[ix][iy] ==0:
            flag +=1
            q = deque()
            q.append((ix,iy,flag ))
            vis [ix][iy] = 1
            arr[ix][iy] = flag
            while q:
                x,y,mask = q.popleft()
                for i in range(4):
                    px = x+nx[i]
                    py = y+ny[i]
                    if px<0 or py<0 or px>=n or py>= n:
                        continue
                    if arr[px][py] ==1 and vis[px][py]==0:
                        vis[px][py] =1
                        arr[px][py] = flag
                        q.append((px,py,mask))
answer = 999999999999999999
for ix in range(n):
    for iy in range(n):
        if arr[ix][iy]!= 0:
            q=deque()
            q.append((ix,iy,arr[ix][iy],-1))
            vis = [[0 for _ in range(n)]for _ in range(n)]
            vis [ix][iy] = 0
            while q:
                x,y,mask,cnt= q.popleft()
                if arr[x][y] != 0 and arr[x][y] != mask:
                    answer = min(answer,cnt)
                    continue
                for i in range(4):
                    px = x+nx[i]
                    py = y+ny[i]
                    if px<0 or py<0 or px>=n or py>= n:
                        continue
                    if arr[px][py] == mask:
                        continue
                    if  vis[px][py] == 0:
                        vis[px][py] = 1
                        q.append((px,py,mask,cnt+1))
print(answer)

