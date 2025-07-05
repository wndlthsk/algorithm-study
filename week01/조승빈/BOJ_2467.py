n  = int(input())
arr = list(map(int,input().split(" ")))
low = 0
high = n-1
a = arr[low]
b = arr[high]
answer = a+b
while low<high:
    if abs(arr[low]+arr[high]) <abs(answer):
        a = arr[low]
        b = arr[high]
        answer=a+b
    if arr[low]+arr[high] < 0:
        low+=1
    elif arr[low]+arr[high] >0:
        high-=1
    else:
        break
print(a,end=" ")
print(b)