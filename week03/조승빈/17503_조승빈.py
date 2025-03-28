N,M,K = map(int,input().split(" "))
arr = []
max_val = 0
for _ in range(K):
    v,c =  map(int,input().split(" "))
    max_val = max(max_val,c)
    arr.append((v,c))
arr= sorted(arr,reverse=True)
low = 0 
high = 2**31-1
while low <= high:
    mid = (low+high) //2 
    cnt = 0
    sum_v = 0
    for v,c in arr:
        if mid>= c:
            cnt+=1
            sum_v+=v
        if cnt == N:
            break
    if sum_v>=M and cnt == N:
        high = mid-1
    else:
        low = mid+1
if high== 2**31-1:
    print(-1)
else:
    print(low)

