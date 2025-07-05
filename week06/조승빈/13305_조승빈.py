n = int(input())
dis = list(map(int,input().split(" ")))
arr = list(map(int,input().split(" ")))
fuel = arr[0] * dis[0]
minValue =arr[0]
for i in range(1,n-1):
    if arr[i] < minValue:
        minValue = arr[i]
    fuel+=minValue*dis[i]
print(fuel)