import sys 
input = sys.stdin.readline
def calc(x1,x2,y1,y2,arr):
    # print("정답")
    print(arr[y1][y2]-arr[x1-1][y2]-arr[y1][x2-1]+arr[x1-1][x2-1])
    #return 

n,m = map(int,input().split(" "))
arr = [[0 for _ in range(n+1)] for _ in range(n+1)]
for i in range(1,n+1):
    cnt = 1 
    for num in list(map(int,input().split(" "))):
        arr[i][cnt] = num
        cnt+=1
for row in range(1,n+1):
    for col in range(1,n+1):
        arr[row][col]+=(arr[row-1][col]+ arr[row][col-1]-arr[row-1][col-1])
# for a in arr:
#     print(a)
for _ in range(m):
    x1,x2,y1,y2 = map(int,input().split(" "))
    calc(x1,x2,y1,y2,arr)