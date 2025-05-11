N = int(input())
arr = [0] * (10001)
arr[0] = 1
for i in range(1,4):
    for idx in range(i,10001):
        arr[idx] +=arr[idx - i]
for _ in range(N):
    T   = int(input())
    print(arr[T])
    