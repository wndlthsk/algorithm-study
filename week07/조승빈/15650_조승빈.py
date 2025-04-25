n, m = map(int ,input().split(" "))

def backTrack(arr,count):
    if len(arr) == m:
        print(*arr)
        return 
    for i in range(count+1,n+1):
       
            arr.append(i)
            backTrack(arr,i)
            arr.pop()
backTrack([],0)