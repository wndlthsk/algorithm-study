N, K = map(int, input().split())

nums = [True] * (N + 1)  # True = 아직 안 지워짐

cnt = 0
for i in range(2, N + 1):
  if nums[i]:
    for j in range(i, N + 1, i):
      if nums[j]:
        nums[j] = False
        cnt += 1
        if cnt == K:
          print(j)
          exit()