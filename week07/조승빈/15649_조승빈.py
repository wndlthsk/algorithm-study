import copy
n, m = map(int ,input().split(" "))
vis= [0]*(n+1)
def backTrack(arr,count):
    if count == m:
        print(*arr)
        return 
    for i in range(1,n+1):
        if vis[i] == 0:
            arr.append(i)
            vis[i] = 1
            backTrack(arr,count+1)
            arr.pop()
            vis[i] = 0
backTrack([],0)