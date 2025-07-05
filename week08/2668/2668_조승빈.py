n =  int(input())
graph = {}
for i in range(n):
    graph[i+1] =i+1
for i in range(n): 
    graph[i+1] = int(input())

answer =  set()
for i in range(1,n+1):
    start = i
    nextNode = graph[i]
    check = 1
    vis =set()
    vis.add(start)
    while i != nextNode: 
        if nextNode in vis: 
            check = 0
            break
        vis.add(nextNode)
        nextNode = graph[nextNode]
        
    if check == 1:
        answer.add(i)
answer = sorted(list(answer))
print(len(answer))
for a in answer:
    print(a)
