from collections import deque
def BFS(x,y):
    flag = arr[x][y]
    q = deque()
    q.append((x,y))
    while q:
        x,y = q.popleft()
        for i in range(4):
            px = x+nx[i]
            py = y+ny[i]
            if px<0 or py<0 or px>=n or py>=n:
                continue
            if arr[px][py] == flag and vis[px][py]== 0:
                vis[px][py]=1
                q.append((px,py))
def BFS_RB(x,y):
    q = deque()
    q.append((x,y))
    while q:
        x,y = q.popleft()
        for i in range(4):
            px = x+nx[i]
            py = y+ny[i]
            if px<0 or py<0 or px>=n or py>=n:
                continue
            if (arr[px][py] == "R"  or  arr[px][py] == "G") and vis[px][py]== 0:
                vis[px][py]=1
                q.append((px,py))               
n = int(input())
arr = []
nx = [-1,1,0,0]
ny = [0,0,-1,1]
vis = [[0 for _ in range(n)]for _ in range(n)]
for x in range(n):
    arr.append(list(input()))
cnt = 0
for x in range(n):
    for y in range(n):
        if vis[x][y] == 0:
            BFS(x,y)
            cnt+=1
print(cnt,end=" ")
vis = [[0 for _ in range(n)]for _ in range(n)]
cnt = 0
for x in range(n):
    for y in range(n):
        if vis[x][y] == 0 and arr[x][y]=="B":
            BFS(x,y)
            cnt+=1
        elif vis[x][y] == 0 and arr[x][y]!="B":
            BFS_RB(x,y)
            cnt+=1 
print(cnt)
        