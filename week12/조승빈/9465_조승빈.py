T = int(input())
for _ in range(T):
    n = int(input())
    arr =[]
    for _ in range(2):
        arr.append(list(map(int,input().split(" "))))
    
    if n >=2:
        arr[1][1] += arr[0][0]
        arr[0][1] += arr[1][0]
    if n>2:
        for i in range(2,n):
            arr[1][i]+=max(arr[0][i-1],arr[0][i-2])
            arr[0][i]+=max(arr[1][i-1],arr[1][i-2])
    #print(arr)
    print(max(arr[1][-1],arr[0][-1]))