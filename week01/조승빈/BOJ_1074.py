n,r,c = map(int,input().split(" "))
def getDist(x,y,px,py): #x,y는 현재 좌표 px,py는 도착 좌표
    return abs(px-x)+abs(py-y)
if n == 1:
    print(r+c+1)
    exit(0)

stack = []
nx = [0,0,1,1]
ny = [0,1,0,1]
#
stack.append((0,0,2**n,0))
while stack:
    
    x,y,arr_len,cnt = stack.pop()
    
    if arr_len ==2:
        for i in range(abs(r-x)+abs(c-y)):    
            cnt+=1
        print(cnt)
        break
    flag = -1
    arr =[] 
    arr.append(getDist(x,y,r,c))
    arr.append(getDist(x,y+arr_len//2,r,c))
    arr.append(getDist(x+arr_len//2,y,r,c))
    arr.append(getDist(x+arr_len//2,y+arr_len//2,r,c))
    flag= arr.index(min(arr))
    if flag == 0:
        stack.append((x,y,arr_len//2,cnt))
    elif flag == 1:
        stack.append((x,y+arr_len//2,arr_len//2,cnt+(arr_len//2)**2))
    elif flag == 2:
        stack.append((x+arr_len//2,y,arr_len//2,cnt + 2* (arr_len//2)**2))
    elif flag == 3:
        stack.append((x+arr_len//2,y+arr_len//2,arr_len//2,cnt+ 3* (arr_len//2)**2))
    # stack.append((x+arr_len//2,y+arr_len//2,arr_len//2))
    # stack.append((x+arr_len//2,y,arr_len//2))
    # stack.append((x,y+arr_len//2,arr_len//2))
    # stack.append((x,y,arr_len//2))

