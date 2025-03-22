import sys
input =sys.stdin.readline
n,m = map(int,input().split(" "))
arr= list(map(int,input().split(" ")))
for i in range(1,n):
    arr[i] += arr[i-1]
arr.insert(0,0)
for _ in range(m):
    start,end = map(int,input().split(" "))
    print(arr[end]-arr[start-1])
