n, m = map(int, input().split())
arr = list(map(int, input().split()))

prefix_sum = 0
ans = 0
cnt = {0: 1}
for num in arr:
    prefix_sum += num
    if prefix_sum - m in cnt:
        ans += cnt[prefix_sum - m]
    cnt[prefix_sum] = cnt.get(prefix_sum, 0) + 1
print(ans)
