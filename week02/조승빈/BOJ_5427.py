from collections import deque
import sys
input = sys.stdin.readline
T = int(input()) 
nx = [0,0,-1,1]
ny = [-1,1,0,0]
for _ in range(T):
    M,N = map(int,input().split(" "))
    fire = deque()
    q = deque()
    fire_arr = [[0 for y in range(M)]for x in range(N)]
    vis = [[0 for y in range(M)]for x in range(N)]
    arr= []
    for i in range(N):
        tmp = list(input())
        arr.append(tmp)
    for x in range(N):
        for y in range(M):
            if arr[x][y] =="*": #불
                fire.append((x,y))
                fire_arr[x][y] = 1#방문처리
            if arr[x][y] =="@":
                q.append((x,y))
                vis[x][y] = 1
    while fire:
        x,y = fire.popleft()
        for i in range(4):
            px = x+nx[i]
            py = y+ny[i]
            if px<0 or py<0 or px>= N or py>=M:
                continue
            if fire_arr[px][py] == 0 and (arr[px][py] == "." or arr[px][py]=="@"):
                fire_arr[px][py]= fire_arr[x][y]+1
                fire.append((px,py))
    flag = 0 
    # for i in range(N):
    #     print(fire_arr[i])
    # print()
    while q:
        x,y = q.popleft()
        if x== 0 or x==N-1 or y== 0 or y==M-1:
            flag = 1
           
            print(vis[x][y])
            break
        for i in range(4):
            px = x+nx[i]
            py = y+ny[i]
            if px<0 or py<0 or px>= N or py>=M:
                continue
            if vis[px][py] == 0 and arr[px][py] == "." and (vis[x][y]+1<fire_arr[px][py] or fire_arr[px][py]==0) :
                # print(x,y,vis[x][y],fire_arr[px][py])
                vis[px][py]= vis[x][y]+1
                q.append((px,py))
    # for i in range(N):
    #     print(vis[i])
    if flag == 0:
        print("IMPOSSIBLE")