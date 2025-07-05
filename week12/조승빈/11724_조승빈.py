import sys
sys.setrecursionlimit(2000)
input= sys.stdin.readline
n,m = map(int,input().split(" "))
def dfs(node):
    for i in graph[node]:
        if arr[i] == 0:
            arr[i] = 1
            dfs(i)


arr=[0]*(n+1)
graph= {}
for i in range(1,n+1):
    graph[i] =[]
for _ in range(m):
    start,end = map(int,input().split(" "))
    graph[start].append(end)
    graph[end].append(start)
answer = 0
for i in range(1,n+1):
    if arr[i] == 0:
        arr[i] = 1
        dfs(i)
        answer+=1
print(answer)


