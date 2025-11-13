N, C = map(int, input().split())
Xi = sorted([int(input()) for _ in range(N)])

start, end = 1, Xi[-1] - Xi[0]
result = 0

while start <= end:
  mid = (start + end) // 2  # 공유기 간 최소 거리 후보
  count = 1                 # 첫 집에는 무조건 설치
  last_installed = Xi[0]

  # 공유기 설치 가능한 개수 세기
  for i in range(1, N):
    if Xi[i] - last_installed >= mid:
      count += 1
      last_installed = Xi[i]

  # 설치 가능한 공유기 개수가 충분한 경우 → 거리 늘려보기
  if count >= C:
    result = mid
    start = mid + 1
  else:
    end = mid - 1
print(result)