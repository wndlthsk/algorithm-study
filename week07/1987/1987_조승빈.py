n, m = map(int ,input().split(" "))
arr =[]
for _ in  range(n):
    arr.append(list(input()))
nx = [-1,1,0,0]
ny = [0,0,-1,1]
answer = 1
def dfs(x,y,vis):
    global answer
    for i in range(4):
        px = x+nx[i]
        py = y+ny[i]
        if px<0 or py<0 or px>=n or py>=m:
            continue
        if arr[px][py] not in vis:
            vis.add(arr[px][py])
            answer = max(answer,len(vis))
            dfs(px,py,vis)
            vis.remove(arr[px][py])
vis = set()
vis.add(arr[0][0])
dfs(0,0,vis)
print(answer)