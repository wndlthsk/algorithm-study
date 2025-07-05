arr = []
N  = int(input())
for _ in range(N):
    arr.append(input())
for i in range(len(arr[0])-1,-1,-1):
    s = set()
    for idx  in range(N):   
        s.add(arr[idx][i:])
    if len(s) == N:
        print(len(arr[0])-i)
        break
