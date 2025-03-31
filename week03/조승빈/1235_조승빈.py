arr = []
N  = int(input())
for _ in range(N):
    arr.append(input())
for i in range(6,-1,-1):
    s = set()
    for idx  in range(N):   
        s.add(arr[idx][i:])
    if len(s) == N:
        print(7-i)
        break
