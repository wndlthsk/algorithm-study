n = int(input())
m = int(input())
def find(parent,i): #자기의 root 찾기
    if parent[i] != i:
        return find(parent,parent[i])
    return parent[i]
def union(parent,a,b):
    x = find(parent,a)
    y = find(parent,b)
    if x> y:
        parent[x] = y
    else:  
        parent[y] = x

   
parent = []
for i in range(n+1):
    parent.append(i)
for idx in range(1,n+1):
    tmp = list(map(int,input().split(" ")))
    for i in range(1,n+1):
        if tmp[i-1] ==1 : #연결 되어 있으면
            union(parent,idx,i)
path = list(map(int,input().split(" ")))
root = find(parent, path[0]) #시작점의 조상
for city in path[1:]:
    if find(parent, city) != root:
        print("NO")
        exit(0)
print("YES")