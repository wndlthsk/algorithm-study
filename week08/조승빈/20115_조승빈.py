N = int(input())
arr = list(map(int, input().split()))
arr  = sorted(arr)
total = arr[-1]
for i in range(N-2,-1,-1):
    total += arr[i]/2
print(total)