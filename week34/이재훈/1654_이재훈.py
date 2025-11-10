K, N = map(int, input().split())
lines = [int(input()) for _ in range(K)]

start, end = 1, max(lines)
result = 0

while start <= end:
  mid = (start + end) // 2  # 랜선 길이 후보
  count = sum(line // mid for line in lines)  # mid 길이로 잘랐을 때 몇 개 나오는지

  if count >= N:  # 충분히 많이 나옴 → 더 길게 자를 수 있다
    result = mid  # 현재 길이를 저장
    start = mid + 1
  else:  # 너무 적게 나옴 → 더 짧게 잘라야 함
    end = mid - 1
print(result)