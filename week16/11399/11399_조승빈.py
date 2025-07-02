n = int(input())
arr  = list(map(int, input().split()))
arr = sorted(arr)
ans = 0
acc = 0
for time in arr:
    acc += time
    ans += acc
print(ans)
