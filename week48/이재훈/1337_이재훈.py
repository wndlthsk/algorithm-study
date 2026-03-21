import sys
input = sys.stdin.readline

N = int(input())
arr = sorted(set(int(input()) for _ in range(N)))

ans = 0
l = 0

for r in range(len(arr)):
  while arr[r] - arr[l] > 4:
    l += 1
  ans = max(ans, r - l + 1)

print(5 - ans)