from collections import deque
nx = [1,2,2,1,-1,-2,-2,-1]
ny = [-2,-1,1,2,2,1,-1,-2]
N = int (input())
for _ in range(N):
    size = int (input())
    startX,startY = map(int,input().split(" "))
    endX,endY = map(int,input().split(" "))
    q = deque()
    answer = 0
    q.append((startX,startY))
    vis =  [[0 for _ in range(size)] for _ in range(size)]
    vis[startX][startY]  = 1
    while q:
        x,y = q.popleft()
        if x ==endX and y==endY:
            print(vis[x][y]-1)
            break
        for i in range(8):
            px = nx[i]+x
            py = ny[i]+y
            if px < 0 or py<0 or px>=size or py>=size:
                continue
            if vis[px][py]==0:
                q.append((px,py))
                vis[px][py]+=vis[x][y]+1
    