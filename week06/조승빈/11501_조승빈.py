n = int(input())
for _ in range(n):
    T = int(input())
    arr = list(map(int,input().split(" ")))
    maxValue = arr[T-1]
    answer = 0
    for i in  range(T-2,-1,-1):
        if maxValue <=  arr[i]:
            maxValue=  arr[i]
            continue
        answer += (maxValue-arr[i])
    print(answer)
        