N, M = map(int, input().split())
trees = list(map(int, input().split()))

start, end = 1, max(trees)
res = 0

while start <= end:
  mid = (start + end) // 2
  total = 0

  # mid 높이로 잘랐을 때 가져갈 수 있는 나무 길이 계산
  for tree in trees:
    if tree > mid:
      total += tree - mid

  # 필요한 나무 양보다 많으면 -> 더 높이 잘라도 됨
  if total >= M:
    res = mid  # 일단 가능한 높이로 저장
    start = mid + 1
  else:  # 너무 적게 잘랐으면 -> 더 낮게 잘라야 함
    end = mid - 1
print(res)
