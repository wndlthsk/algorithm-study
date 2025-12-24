import sys
input = sys.stdin.readline

N, C = map(int, input().split())
weights = list(map(int, input().split()))

mid = N // 2
left = weights[:mid]
right = weights[mid:]

def get_sub_sums(arr):
  sums = [0]
  for w in arr:
    new = []
    for s in sums:
      new.append(s + w)
    sums += new
  return sums

left_sums = get_sub_sums(left)
right_sums = get_sub_sums(right)
right_sums.sort()

def upper_bound(arr, target):
  l = 0
  r = len(arr)
  while l < r:
    m = (l + r) // 2
    if arr[m] <= target:
      l = m + 1
    else:
      r = m
  return l  # target 이하의 개수

cnt = 0
for ls in left_sums:
  if ls > C:
    continue
  remain = C - ls
  cnt += upper_bound(right_sums, remain)

print(cnt)
