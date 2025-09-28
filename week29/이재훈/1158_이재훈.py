N, K = map(int, input().split())

people = list(range(1, N + 1))  # 1 ~ N

res = []
idx = 0  # 현재 인덱스
while people:
  idx = (idx + K - 1) % len(people)  # K번째 사람 위치
  res.append(people.pop(idx))
print(f"<{', '.join(map(str, res))}>")