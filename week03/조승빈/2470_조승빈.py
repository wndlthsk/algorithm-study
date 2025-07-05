N = int(input())
arr = []

arr = list(map(int,input().split(" ")))
arr = sorted(arr)
low = 0
high = N-1
a = arr[low]
b = arr[high]
answer = 9999999999999999
while low < high:
    if answer > abs(arr[low] + arr[high]):
        answer = abs(arr[low] + arr[high])
        a = arr[low]
        b = arr[high]
    if arr[low] + arr[high] < 0:
        low+=1
    elif arr[low] + arr[high] > 0:
        high -=1
    else:
        break
print(a,end=" ")
print(b)