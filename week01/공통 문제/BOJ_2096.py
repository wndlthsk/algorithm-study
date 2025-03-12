n = int(input())
arr = []
arr_max = [[0,0,0]for i in range(n)]
for _ in range(n):
    arr.append(list(map(int,input().split(" "))))
for i in range(3):
    arr_max[0][i] = arr[0][i]
    
for idx in range(1,n):
    arr_max[idx][0] = max(arr_max[idx-1][0], arr_max[idx-1][1])+arr[idx][0]
    arr_max[idx][1] = max(arr_max[idx-1][0], arr_max[idx-1][1],arr_max[idx-1][2])+arr[idx][1]
    arr_max[idx][2] = max(arr_max[idx-1][1], arr_max[idx-1][2])+arr[idx][2]
print(max(arr_max[-1]),end=" ")
for r in range(n):
    for c in range(3):
        arr_max[r][c] = 99999999999
for i in range(3):
    arr_max[0][i] = arr[0][i]
for idx in range(1,n):
    arr_max[idx][0] = min(arr_max[idx-1][0], arr_max[idx-1][1])+arr[idx][0]
    arr_max[idx][1] = min(arr_max[idx-1][0], arr_max[idx-1][1],arr_max[idx-1][2])+arr[idx][1]
    arr_max[idx][2] = min(arr_max[idx-1][1], arr_max[idx-1][2])+arr[idx][2]
print(min(arr_max[-1]))