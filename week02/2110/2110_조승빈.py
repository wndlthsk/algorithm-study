import sys
input =sys.stdin.readline
n,m  =  map(int,input().split(" "))
arr = []
for i in range(n):
    arr.append(int(input()))
arr = sorted(arr)
low = 1
high = arr[-1] - arr[0]
cnt = 0
while low<=high:
    mid = (low+high) // 2
    h = arr[0]
    cnt = 1
    for i in range(1,n):
        if arr[i] - h >= mid: 
            h = arr[i]
            cnt += 1
    if cnt >= m:
        low = mid + 1
    else:
        high = mid - 1

print(high)

